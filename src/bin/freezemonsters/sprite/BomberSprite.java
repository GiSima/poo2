package bin.freezemonsters.sprite;

import bin.spriteframework.sprite.BadSprite;
import bin.spriteframework.sprite.BadnessBoxSprite;

import java.util.LinkedList;


public class BomberSprite extends BadnessBoxSprite {
    protected Goo goo;
    public BomberSprite(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Goo getBomb() {
        return goo;
    }

    @Override
    public LinkedList<BadSprite> getBadnesses() {
        LinkedList<BadSprite> aSlime = new LinkedList<>();
        aSlime.add(goo);
        return aSlime;
    }
}
