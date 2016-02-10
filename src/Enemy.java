import java.awt.Color;

public class Enemy extends Player

	implements Runnable
	{
  int directionX = 1;
  int directionY = 1;

  public Enemy(int x, int y, int w, int h,Color color)
  {
    super(x, y, w, h,color);
    //System.out.println(" enemyBall  x, y = " + x + "  " + y);
  }

  private boolean isAlive = true;
  public void randMove()
  {
   if(isAlive){
	   if (this.x <= 0) this.directionX = 1;
	   if (this.x >= 1000-this.w-20) this.directionX = -1; //窗口的宽度是1000，可以改成变量
	   if (this.y <= 0) this.directionY = 1;
   		if (this.y >= 600-this.w) this.directionY = -1; //窗口的高度是600，可以改成变量
   		this.x += this.directionX * 2;
   		this.y += this.directionY * 2;
   		try {
			Thread.sleep(5L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
   else{
	   this.w = 0;
	   this.h = 0;
	   this.x = 1500;
	   this.y = 1500;
   }
  }
  public void setState(boolean aliveOrNot){
	  isAlive = aliveOrNot;
  }
  public boolean getState(){
	  return isAlive;
  }
 
	  public void run()
	  {
		  while (isAlive)
			  randMove();
	
	  }


}