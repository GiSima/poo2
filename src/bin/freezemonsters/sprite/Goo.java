package bin.freezemonsters.sprite;

import bin.ImageResizer;
import bin.spriteframework.sprite.BadSprite;

import javax.swing.*;
import java.util.LinkedList;

public class Goo extends BadSprite {
    private boolean destroyed;

    public Goo(String path, int x, int y, int width, int height) {
        this.path = path;
        this.width = width;
        this.height = height;
        initializeBomb(x, y);
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
}
