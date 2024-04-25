package bin.spriteframework.sprite;

import bin.ImageResizer;
import bin.spriteframework.Direction;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import static bin.spriteframework.Commons.*;
import static bin.spriteframework.Direction.*;

public class Player extends Sprite {
    private int width;
    private int height;
    private final String path;
    protected int dx;
    protected int dy;
    protected Direction lastDirection;

    public Player(String path, int width, int height, int x, int y) {
        this.path = path;
        this.width = width;
        this.height = height;
        loadImage();
        resetState();
        setDirection(x, y);
    }

    protected void loadImage() {
        ImageIcon resizedIcon = ImageResizer.resizeImage(path, width, height);
        width = resizedIcon.getIconWidth();
        height = resizedIcon.getIconHeight();
        setImage(resizedIcon.getImage());
    }

    public void act(int width, int height) {
        x += dx * direction[0];
        y += dy * direction[1];
        constrainToBoardBounds(width, height);
    }

    private void constrainToBoardBounds(int width, int height) {
        x = Math.max(2, Math.min(width - 2 * this.width, x));
        y = Math.max(2, Math.min(height - 2 * this.height, y));
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -PLAYER_SPEED;
            lastDirection = LEFT;
//            setDirection(-1, 0);
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = PLAYER_SPEED;
            lastDirection = RIGHT;
//            setDirection(1, 0);
        } else if (key == KeyEvent.VK_UP) {
            dy = -PLAYER_SPEED;
            lastDirection = DOWN;
//            setDirection(0, -1);
        } else if (key == KeyEvent.VK_DOWN) {
            dy = PLAYER_SPEED;
            lastDirection = UP;
//            setDirection(0, 1);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    private void resetState() {
        setX(INIT_PLAYER_X);
        setY(INIT_PLAYER_Y);
    }

    public Direction getLastDirection(){
        return lastDirection;
    }
}
