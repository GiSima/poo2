package bin.freezemonsters;

import bin.spaceinvaders.SpaceInvadersGame;
import bin.spriteframework.AbstractBoard;
import bin.spriteframework.MainFrame;

import java.awt.*;

public class FreezeMonstersGame extends MainFrame {

    public FreezeMonstersGame() {
        super("Freeze Monsters");
    }

    @Override
    protected AbstractBoard createBoard() {
        return null;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new FreezeMonstersGame();
        });
    }

}
