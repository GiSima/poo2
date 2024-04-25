package bin.freezemonsters;

import static bin.freezemonsters.CommonsFreezeMonsters.*;
import static bin.spriteframework.Direction.*;

import bin.freezemonsters.sprite.*;
import bin.spriteframework.AbstractBoard;
import bin.spriteframework.Direction;
import bin.spriteframework.sprite.BadSprite;
import bin.spriteframework.sprite.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FreezeMonstersBoard extends AbstractBoard {
    private Freeze freeze;
    private int deaths;

    public FreezeMonstersBoard() {
        super(new FreezeMonstersSpriteFactory(), BOARD_WIDTH, BOARD_HEIGHT);
    }

    @Override
    protected void createBadSprites() {
        int randX;
        int randY;
        for (int i = 0; i < NUMBER_OF_MONSTERS; i++){
            randX = ThreadLocalRandom.current().nextInt(MONSTER_WIDTH,getWidth() - MONSTER_WIDTH);
            randY = ThreadLocalRandom.current().nextInt(MONSTER_HEIGHT,getHeight() - MONSTER_HEIGHT);

            Monster monster = (Monster) spriteFactory.createBadSprite(randX, randY);
            badSprites.add(monster);
        }
    }

    @Override
    protected void createOtherSprites() {
        freeze = new Freeze();
        freeze.setDirection(UP);
    }

    @Override
    protected void drawOtherSprites(Graphics g) {
        drawShot(g);
    }

    private void drawShot(Graphics g) {
        if (freeze.isVisible()) {
            g.drawImage(freeze.getImage(), freeze.getX(), freeze.getY(), this);
        }
    }

    @Override
    protected void processOtherSprites(Player player, KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && inGame) {
            if (freeze == null || !freeze.isVisible()) {
                freeze = (Freeze) spriteFactory.createRay(player.getX(), player.getY());
                freeze.setDirection(player.getLastDirection());
                if(freeze.getDirection() == null) freeze.setDirection(UP);
            }
        }
    }

    @Override
    protected void update() {
        updateGameStatus();
        updatePlayer();
        updateShots();
        updateMonsters();
        updateBombs();
    }

    private void updateGameStatus() {
        if (deaths == NUMBER_OF_MONSTERS - 5) {
            inGame = false;
            timer.stop();
            message = "Game won!";
        }
    }

    private void updatePlayer() {
        for (Player p : players) {
            p.act(getWidth(), getHeight());
        };
    }

    private void updateShots() {
        if (freeze.isVisible()) {
            moveShot();
            checkShotCollisions();
        }
    }

    private void moveShot() {
        int move = SHOT_MOVEMENT;
        Direction d = freeze.getDirection();
        if (d == null) d = UP;
        switch (d) {
            case UP -> freeze.moveY(move);
            case DOWN -> freeze.moveY(-move);
            case RIGHT -> freeze.moveX(move);
            case LEFT -> freeze.moveX(-move);
        }
        if (freeze.getX() < 0 || freeze.getX() > getWidth()
                || freeze.getY() < 0 || freeze.getY() > getHeight()) freeze.die();
    }

    private void checkShotCollisions() {
        int shotX = freeze.getX();
        int shotY = freeze.getY();
        for (BadSprite monster : badSprites) {
            if (monster.isVisible() && freeze.isVisible() && shotHitsMonters(shotX, shotY, monster)) {
                ImageIcon ii = new ImageIcon(IMAGE_EXPLOSION);
                monster.setImage(ii.getImage());
                monster.setDying(true);
                deaths++;
                freeze.die();
            }
        }
    }

    private boolean shotHitsMonters(int shotX, int shotY, BadSprite monster) {
        int monsterX = monster.getX();
        int monsterY = monster.getY();
        return shotX >= monsterX && shotX <= (monsterX + MONSTER_WIDTH) && shotY >= monsterY && shotY <= (monsterY + MONSTER_HEIGHT);
    }

    private void updateMonsters() {
        for (BadSprite monster : badSprites) {
            if (monster.isVisible()) {
                Direction d = ((Monster) monster).getDirection();
                switch (d){
                    case UP -> monster.moveY(-MONSTER_MOVEMENT);
                    case DOWN -> monster.moveY(MONSTER_MOVEMENT);
                    case LEFT -> monster.moveX(-MONSTER_MOVEMENT);
                    case RIGHT -> monster.moveX(MONSTER_MOVEMENT);
                }
                checkMonsterBounds((Monster) monster);
            }
        }
    }

    private void checkMonsterBounds(Monster monster) {
        int x = monster.getX();
        int y = monster.getY();
        if (x < BORDER_RIGHT + MONSTER_WIDTH || x > BOARD_WIDTH - BORDER_RIGHT - MONSTER_WIDTH
                || y < BORDER_RIGHT + MONSTER_HEIGHT || y > BOARD_HEIGHT - BORDER_RIGHT - MONSTER_HEIGHT){
            monster.changeDirection();
        }
    }

//    private void shiftMonsterDirection(int newDirection) {
//        badSprites.forEach(a -> a.setY(a.getY() + GO_DOWN));
//        direction = newDirection;
//    }

    private void updateBombs() {
        Random generator = new Random();
        for (BadSprite monster : badSprites) {
            Goo goo = ((BomberSprite) monster).getBomb();
            maybeDropGoo(generator, monster, goo);
            moveBomb(goo);
            checkBombCollisions(goo);
        }
    }

    private void maybeDropGoo(Random generator, BadSprite monster, Goo goo) {
        if (generator.nextInt(15) == CHANCE && monster.isVisible() && goo.isDestroyed()) {
            goo.setDestroyed(false);
            goo.setX(monster.getX());
            goo.setY(monster.getY());
        }
    }

    private void moveBomb(Goo goo) {//bomba chegue até a parte inferior da tela
        if (!goo.isDestroyed()) {
            goo.setY(goo.getY() + 1);

            if (goo.getY() >= BOARD_HEIGHT - BOMB_HEIGHT) {
                goo.setDestroyed(true);
            }
        }
    }

    private void checkBombCollisions(Goo goo) {
        for (Player player : players) {
            if (player.isVisible() && !goo.isDestroyed() && bombHitsPlayer(goo, player)) {
                ImageIcon ii = new ImageIcon(IMAGE_EXPLOSION);
                player.setImage(ii.getImage());
                player.setDying(true);
                goo.setDestroyed(true);
            }
        }
    }

    private boolean bombHitsPlayer(Goo goo, Player player) {
        int bombX = goo.getX();
        int bombY = goo.getY();
        int playerX = player.getX();
        int playerY = player.getY();
        return bombX >= playerX && bombX <= (playerX + PLAYER_WIDTH) && bombY >= playerY && bombY <= (playerY + PLAYER_HEIGHT);
    }
}
