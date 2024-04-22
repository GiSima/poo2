package bin.spaceinvaders;

import java.awt.EventQueue;

import bin.spriteframework.AbstractBoard;
import bin.spriteframework.MainFrame;

public class SpaceInvadersGame extends MainFrame {
	public SpaceInvadersGame () {
		super("Space Invaders");
	}
	
	protected AbstractBoard createBoard() {
		return new SpaceInvadersBoard();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new SpaceInvadersGame();
		});
	}
}
