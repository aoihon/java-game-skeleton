package game.test;

import game.framework.GameFrame;

import java.awt.Dimension;

public class GameMain{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static void main(String[] args) {
		Dimension size = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
		GameComponent component = new GameComponent(size);
		GameFrame frame = new GameFrame(size, component, "ゲームのタイトル");
	}

}
