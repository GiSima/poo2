package bin.freezemonsters.sprite;

import bin.ImageResizer;
import bin.spriteframework.Direction;
import bin.spriteframework.sprite.BadSprite;

import javax.swing.*;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import static bin.spriteframework.Direction.*;
import static bin.spriteframework.Direction.RIGHT;

public class Goo extends BadSprite {
    Direction direction;
    private boolean destroyed;

    public Goo(String path, int x, int y, int width, int height) {
        this.path = path;
        this.width = width;
        this.height = height;
        initializeBomb(x, y);
        setDirection(1,1);
        int rand = ThreadLocalRandom.current().nextInt(3);
        switch (rand) {
            case 0 -> direction = UP;
            case 1 -> direction = DOWN;
            case 2 -> direction = LEFT;
            case 3 -> direction = RIGHT;
        }
    }

    private void initializeBomb(int x, int y) {
        setDestroyed(true);

        this.x = x;
        this.y = y;

        ImageIcon resizedIcon = ImageResizer.resizeImage(path,  width, height);
        setImage(resizedIcon.getImage());
    }

    public void setDestroyed(boolean isDestroyed) {
        destroyed = isDestroyed;
    }

    @Override
    public LinkedList<BadSprite> getBadnesses() {
        return null;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public Direction getDirection() {
        return direction;
    }
}
