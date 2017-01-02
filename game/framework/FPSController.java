package game.framework;

public class FPSController {
	private long startTime;
	private int counter;
	private final int SAMPLINGS = 60;
	private long fps;
	public FPSController(){
		this(60);
	}
	public FPSController(long fps){
		this.fps = fps;
	}
	
	/** FPS制御に用いる変数を更新する */
	public void update(){
		// 最初の1回目は時間の計測
		if(counter == 0){
			startTime = System.currentTimeMillis();
		}
		// 指定のサンプリング数に達したら平均を計算する
		if(counter == SAMPLINGS){
			long end = System.currentTimeMillis();
			// 平均を計算する
			fps = (long) (1000.0f/((end-startTime)/(long)SAMPLINGS));
			counter = 0;
			startTime = end;
		}
		counter++;
	}
	
	/** サンプリングした平均値を基に数ミリ秒待つ */
	public void stop(){
		long tookTime = System.currentTimeMillis() - startTime;
		long waitTime = (long) ((counter * 1000.0f / fps) - tookTime);
//		System.out.println("wt : " + waitTime);
		try{
			Thread.sleep((long) (waitTime));
		}catch(Exception e){
		}
	}
}
