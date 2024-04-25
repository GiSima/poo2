package bin.spriteframework.sprite;

public interface SpriteFactory {
    Player createPlayer();
    BadSprite createBadSprite(int x, int y);
    BadSprite createRay(int x, int y);

}
