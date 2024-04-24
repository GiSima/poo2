package bin.spaceinvaders.sprite;

import bin.ImageResizer;
import bin.spaceinvaders.sprite.Bomb;
import bin.spaceinvaders.sprite.BomberSprite;

import javax.swing.*;

import static bin.spaceinvaders.CommonsSpaceInvaders.*;

public class Alien extends BomberSprite {
    public Alien(int x, int y, int width, int height) {
        super(width, height);
        initBomber(x,y);
    }
    private void initBomber(int x, int y) {
        this.x = x;
        this.y = y;
        bomb = new Bomb(IMAGE_BOMB, x, y, BOMB_WIDTH, BOMB_HEIGHT);
        ImageIcon resizedIcon = ImageResizer.resizeImage(IMAGE_ALIEN, width, height);
        setImage(resizedIcon.getImage());
    }
}
