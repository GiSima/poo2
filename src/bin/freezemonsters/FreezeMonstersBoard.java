package bin.freezemonsters;

import bin.spriteframework.AbstractBoard;
import bin.spriteframework.sprite.Player;
import bin.spriteframework.sprite.SpriteFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FreezeMonstersBoard extends AbstractBoard {
    public FreezeMonstersBoard() {
        super(new FreezeMonstersSpriteFactory());
    }

    @Override
    protected void createOtherSprites() {

    }

    @Override
    protected void drawOtherSprites(Graphics var1) {

    }

    @Override
    protected void update() {

    }

    @Override
    protected void processOtherSprites(Player var1, KeyEvent var2) {

    }
}
