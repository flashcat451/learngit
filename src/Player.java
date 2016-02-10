import java.awt.Color;

/**
 * 
 * @author apple
 * 
 */
public class Player {
	protected int  w,h;
	protected int x;
	protected int y;
	protected int dx = 0;
	protected int dy = 0;
	protected Color color ;
	private int speed = 1;

	public Player(int x,int y,int w,int h,Color color){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
	}
	

	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}


	/**
	 * 用给定的前景色画一个圆点，贴一张图片？
	 */
	
	
