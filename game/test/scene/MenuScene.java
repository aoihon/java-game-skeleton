package game.test.scene;

import game.framework.GameScene;
import game.test.GameMain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * ゲームの処理を書くところ
 * 
 */
public class MenuScene implements GameScene {

	private Ball ball;
	public MenuScene() {
		ball = new Ball(new Point(100,10), new Dimension(10,10), new Point(5,5));
	}
	
	/**	描画処理を書くところ */
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GameMain.WINDOW_WIDTH, GameMain.WINDOW_HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(ball.point.x, ball.point.y, ball.size.width,ball.size.height);
//		g.drawImage(presenImage, 0, 0, this);
	}
	
	/** 計算処理を書くところ */
	public boolean calculate() {
		ball.move();
		return false;
	}
	
	/** テスト用のボール */
	private class Ball{
		public Point point ;
		private Dimension size;
		private Point direction;
		
		public Ball(Point pos, Dimension s, Point dir){
			point = new Point(pos);
			size = new Dimension(s);
			direction = new Point(dir);
		}
		public void move(){
			int x = point.x;
			int y = point.y;
			if(x + direction.x + size.width > GameMain.WINDOW_WIDTH){
				x = GameMain.WINDOW_WIDTH-size.width;
				direction.x *= -1;
			}else if(x + direction.x < 0){
				x = 0;
				direction.x *= -1;
			}else{
				x += direction.x;
			}

			if(y + direction.y + size.height > GameMain.WINDOW_HEIGHT){
				y = GameMain.WINDOW_HEIGHT-size.height;
				direction.y *= -1;
			}else if(y + direction.y < 0){
				y = 0;
				direction.y *= -1;
			}else{
				y += direction.y;
			}
			
			point.setLocation(x,y);
		}
	}
}
