package bin.spaceinvaders;

import java.awt.EventQueue;

import bin.spriteframework.sprite.SpriteFactory;
import bin.spriteframework.AbstractBoard;
import bin.spriteframework.MainFrame;
import bin.SpaceInvaders.SpaceInvadersBoard;

public class SpaceInvadersGame extends MainFrame {
	public SpaceInvadersGame () {
		super("Space Invaders", new SpaceInvadersSpriteFactory());
	}
	protected  AbstractBoard createBoard(SpriteFactory spriteFactory) {
		return new SpaceInvadersBoard(spriteFactory);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new SpaceInvadersGame();
		});
	}
}
