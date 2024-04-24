package bin.freezemonsters;

import bin.spaceinvaders.sprite.BomberSprite;
import bin.spaceinvaders.sprite.Shot;
import bin.spriteframework.sprite.Player;
import bin.spriteframework.sprite.SpriteFactory;

public class FreezeMonstersSpriteFactory implements SpriteFactory {
    @Override
    public Player createPlayer() {
        return null;
    }

    @Override
    public BomberSprite createBadSprite(int x, int y) {
        return null;
    }

    @Override
    public Shot createRay(int x, int y) {
        return null;
    }

//    @Override
//    public Shot createRay() {
//        return null;
//    }
}
