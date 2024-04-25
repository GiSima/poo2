package bin.spriteframework.sprite;

import java.util.LinkedList;

public abstract class BadSprite extends Sprite {

    public abstract LinkedList<BadSprite> getBadnesses();

    public abstract boolean isDestroyed();
}
