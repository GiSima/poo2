package bin.freezemonsters;

public interface CommonsFreezeMonsters extends bin.spriteframework.Commons{
    int BOARD_WIDTH = 1000;
    int BOARD_HEIGHT = 700;
    int BOMB_HEIGHT = 20;
    int BOMB_WIDTH = BOMB_HEIGHT;
    int SHOT_HEIGHT = 20;
    int SHOT_WIDTH = SHOT_HEIGHT;
    int SHOT_MOVEMENT = 4;
//    Trevisan:
//    String IMAGE_MONSTER ="SpaceInvaders/images/alien.png" ;
//    String IMAGE_BOMB = "SpaceInvaders/images/bomb.png";
//    String IMAGE_EXPLOSION ="SpaceInvaders/images/explosion.png" ;
//    String IMAGE_PLAYER="SpaceInvaders/images/player.png";
//    String IMAGE_SHOT = "SpaceInvaders/images/shot.png";

    //    Giovane:
    String IMAGE_MONSTER = "/home/simamoto/Faculdade/Quinto Periodo/POO2/tarefa final 01/src/bin/freezemonsters/images/monster" ;
    String IMAGE_BOMB = "/home/simamoto/Faculdade/Quinto Periodo/POO2/tarefa final 01/src/bin/freezemonsters/images/gosma.png";
    String IMAGE_EXPLOSION = "" ;
    String IMAGE_SHOT = "/home/simamoto/Faculdade/Quinto Periodo/POO2/tarefa final 01/src/bin/freezemonsters/images/ray.png";
    String IMAGE_PLAYER="/home/simamoto/Faculdade/Quinto Periodo/POO2/tarefa final 01/src/bin/freezemonsters/images/woody.png";
    int MONSTER_HEIGHT = 48;
    int MONSTER_WIDTH = 48;
    int MONSTER_MOVEMENT = 2;
    int NUMBER_OF_MONSTERS = 10;
    int CHANCE = 5;
    int PLAYER_WIDTH = 30;
    int PLAYER_HEIGHT = 70;
}
