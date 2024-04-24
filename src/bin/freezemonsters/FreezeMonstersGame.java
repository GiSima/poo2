package bin.freezemonsters;

import bin.spriteframework.AbstractBoard;
import bin.spriteframework.sprite.SpriteFactory;

public class FreezeMonstersGame extends bin.spriteframework.MainFrame{
    public FreezeMonstersGame(String t, SpriteFactory spriteFactory) {
        super(t, spriteFactory);
    }

    @Override
    protected AbstractBoard createBoard(SpriteFactory spriteFactory) {
        return new FreezeMonstersBoard();
    }
}
