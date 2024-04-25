package bin.freezemonsters.sprite;

import bin.ImageResizer;
import bin.spriteframework.Direction;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

import static bin.freezemonsters.CommonsFreezeMonsters.*;
import static bin.spriteframework.Direction.*;

public class Monster extends BomberSprite {
    Direction direction;
    public Monster(int x, int y, int width, int height) {
        super(width, height);
        initBomber(x,y);
    }
    private void initBomber(int x, int y) {
        this.x = x;
        this.y = y;
        goo = new Goo(IMAGE_BOMB, x, y, BOMB_WIDTH, BOMB_HEIGHT);
        int rand = ThreadLocalRandom.current().nextInt(1,9);
        ImageIcon resizedIcon = ImageResizer.resizeImage(IMAGE_MONSTER + rand + ".png", width, height);
        setImage(resizedIcon.getImage());
        changeDirection();
    }

    public void changeDirection(){
        int rand = ThreadLocalRandom.current().nextInt(0,3);
        switch (rand) {
            case 0 -> direction = UP;
            case 1 -> direction = DOWN;
            case 2 -> direction = LEFT;
            case 3 -> direction = RIGHT;
        }
    }

    public Direction getDirection() {
        return direction;
    }
}
