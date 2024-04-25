package bin.freezemonsters;

import bin.spaceinvaders.SpaceInvadersGame;
import bin.spriteframework.AbstractBoard;
import bin.spriteframework.sprite.SpriteFactory;

import java.awt.*;

import static bin.freezemonsters.CommonsFreezeMonsters.*;

public class FreezeMonstersGame extends bin.spriteframework.MainFrame{
    public FreezeMonstersGame() {
        super("Freeze Monsters", new FreezeMonstersSpriteFactory(), new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }

    @Override
    protected AbstractBoard createBoard(SpriteFactory spriteFactory) {
        return new FreezeMonstersBoard();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FreezeMonstersGame();
        });
    }

}
