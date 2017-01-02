package game.framework;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame(Dimension size, RunnableComponent component, String title){
//		setSize(size);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		// フレームのボタンなどを消す
//		setUndecorated(true);
		// Undecoratedのあとに背景色を決定しておく
		setBackground(Color.WHITE);
		// ウィンドウに表示するタイトルの文字を決定する
		setTitle(title);
		// ゲーム画面（内部）を追加する
		getContentPane().add(component);
		// ゲーム画面（内部）の大きさを決定する
		getContentPane().setPreferredSize(size);
		// 画面サイズを変更できなくする
		setResizable(false);
		// ゲームを開始する
		(new Thread(component)).start();

		// 内部の大きさに合わせてフレームのサイズを決定する
        pack();
        // 画面の中央に配置する
		setLocationRelativeTo(null);

		// ウィンドウを表示する
		setVisible(true);
	}

}
