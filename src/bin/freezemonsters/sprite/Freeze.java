package bin.freezemonsters.sprite;

import bin.ImageResizer;
import bin.spriteframework.Direction;
import bin.spriteframework.sprite.BadSprite;

import javax.swing.*;
import java.util.LinkedList;

public class Freeze extends BadSprite {
    private Direction direction;
    public Freeze() {
        setVisible(false);
    }

    public Freeze(String path, int x, int y, int width, int height) {
        setDirection(1,1);
        this.path = path;
        this.width = width;
        this.height = height;
        initializeRay(x, y);
    }

    private void initializeRay(int x, int y) {
        ImageIcon resizedIcon = ImageResizer.resizeImage(path, width, height);
        setImage(resizedIcon.getImage());
        setVisible(true);
        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction lastDirection) {
        this.direction = lastDirection;
    }

    @Override
    public LinkedList<BadSprite> getBadnesses() {
        return null;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }
}
