package bin.spriteframework.sprite;

import bin.spaceinvaders.sprite.BomberSprite;
import bin.spaceinvaders.sprite.Shot;

public interface SpriteFactory {
    Player createPlayer();
    BomberSprite createBadSprite(int x, int y);
    Shot createRay(int x, int y);

}
