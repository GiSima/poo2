package bin.spriteframework;

import bin.spriteframework.sprite.SpriteFactory;

import javax.swing.*;

import java.awt.*;

import static bin.spriteframework.Commons.*;

public abstract class MainFrame extends JFrame {
    protected abstract AbstractBoard createBoard(SpriteFactory spriteFactory);

    public MainFrame(String t, SpriteFactory spriteFactory, Dimension d) {
        this.add(this.createBoard(spriteFactory));
        this.setTitle(t);
        this.setSize(d.width, d.height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
