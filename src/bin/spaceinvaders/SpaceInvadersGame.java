package bin.spaceinvaders;

import java.awt.*;

import bin.spriteframework.sprite.SpriteFactory;
import bin.spriteframework.AbstractBoard;
import bin.spriteframework.MainFrame;

import static bin.spaceinvaders.CommonsSpaceInvaders.BOARD_HEIGHT;
import static bin.spaceinvaders.CommonsSpaceInvaders.BOARD_WIDTH;

public class SpaceInvadersGame extends MainFrame {
	public SpaceInvadersGame () {
		super("Space Invaders",
				new SpaceInvadersSpriteFactory(),
				new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
	}
	protected AbstractBoard createBoard(SpriteFactory spriteFactory) {
		return new SpaceInvadersBoard(spriteFactory);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new SpaceInvadersGame();
		});
	}
}
