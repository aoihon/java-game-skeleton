package game.framework;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public abstract class RunnableComponent extends JComponent implements Runnable {

	
	private FPSController fpsCtrl;
	/** 
	 * コンストラクタ
	 * @param size 画面のサイズ
	 */
	public RunnableComponent(Dimension size) {
		setDoubleBuffered(true);
		setSize(size.width, size.height);
		fpsCtrl = new FPSController(60);
//		(new Thread(this)).start();
	}

	/** repaintで呼ばれるメソッド */
	public void paintComponent(Graphics g) {
		updateGraphics(g);
	}
	
	/** 描画処理 */
	protected abstract void updateGraphics(Graphics g);
	
	/** 計算処理 */
	protected abstract void calculate();

	public void run() {
		while (true) {
			// fps制御
			fpsCtrl.update();
			// 計算処理
			calculate();
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					// 描画処理を呼び出す
					repaint();
				}
			});
			fpsCtrl.stop();
		}

	}
}
