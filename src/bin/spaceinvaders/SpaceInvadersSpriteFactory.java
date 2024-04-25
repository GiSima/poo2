package bin.spaceinvaders;

import bin.spaceinvaders.sprite.Alien;
import bin.spaceinvaders.sprite.Shot;
import bin.spriteframework.sprite.*;

import static bin.spaceinvaders.CommonsSpaceInvaders.*;

public class SpaceInvadersSpriteFactory implements SpriteFactory {
    @Override
    public Player createPlayer() {
        return new Player(IMAGE_PLAYER, PLAYER_WIDTH, PLAYER_HEIGHT, 1, 0);
    }

    @Override
    public Alien createBadSprite(int x, int y) {
        Alien alien = new Alien(x, y, ALIEN_WIDTH, ALIEN_HEIGHT);
        alien.setDirection(1,0);
        return alien;
    }

    @Override
    public Shot createRay(int x, int y) {
        return new Shot(IMAGE_SHOT,x, y, SHOT_WIDTH, SHOT_HEIGHT);
    }


}