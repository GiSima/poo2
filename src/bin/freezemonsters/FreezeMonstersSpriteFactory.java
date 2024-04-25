package bin.freezemonsters;

import bin.freezemonsters.sprite.Monster;
import bin.freezemonsters.sprite.Freeze;
import bin.spriteframework.sprite.Player;
import bin.spriteframework.sprite.SpriteFactory;

import static bin.freezemonsters.CommonsFreezeMonsters.*;

public class FreezeMonstersSpriteFactory implements SpriteFactory {
    @Override
    public Player createPlayer() {
        return new Player(IMAGE_PLAYER, PLAYER_WIDTH, PLAYER_HEIGHT, 1, 1);
    }

    @Override
    public Monster createBadSprite(int x, int y) {
        Monster monster = new Monster(x, y, MONSTER_WIDTH, MONSTER_HEIGHT);
        monster.setDirection(1,1);
        return monster;
    }

    @Override
    public Freeze createRay(int x, int y) {
        return new Freeze(IMAGE_SHOT,x, y, SHOT_WIDTH, SHOT_HEIGHT);
    }
}
