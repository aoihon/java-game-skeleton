package game.test;

import game.framework.GameScene;
import game.framework.RunnableComponent;
import game.test.scene.MenuScene;

import java.awt.Dimension;
import java.awt.Graphics;

public class GameComponent extends RunnableComponent {
	
	private GameScene scene;
	/**
	 * コンストラクタ
	 * @param size 画面のサイズを設定する
	 */
	public GameComponent(Dimension size) {
		super(size);
		scene = new MenuScene();
	}

	/** 描画処理 */
	protected void updateGraphics(Graphics g) {
		if(scene != null){
			scene.paint(g);
		}
	}

	/** 計算処理 */
	protected void calculate() {
		if(scene != null){
			scene.calculate();
		}
	}

}
