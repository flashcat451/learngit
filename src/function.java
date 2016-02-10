import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 * 
 * @author apple
 * 把常用的方法放到function接口中，方便管理。
 */

public interface function {
/**
 * 指定的球向着鼠标点击的地方前进
 * @param p1
 * @param pictureDrawer
 */
	default void playerMoveToMouseClick(Player p1,PictureDrawer pictureDrawer)
{
	if  ((p1.x != pictureDrawer.getMouseClickX()) || (p1.y != pictureDrawer.getMouseClickY())) {// if  yellow-ball step by step to nearly the mouseClick location
		
	      if (pictureDrawer.getMouseClickX() - p1.x != 0) {
	    	  		p1.x += (pictureDrawer.getMouseClickX() - p1.x) / Math.abs(pictureDrawer.getMouseClickX() - p1.x) * p1.getSpeed();
	      			}
	      			else  	p1.x += 0;
	      	if (pictureDrawer.getMouseClickY() - p1.y != 0) {
	      			p1.y += (pictureDrawer.getMouseClickY() - p1.y) / Math.abs(pictureDrawer.getMouseClickY() - p1.y) * p1.getSpeed();
	      		}
	      			else { 	p1.y += 0;  }
	      try
	      {
	        Thread.sleep(10L);
	      }
	      catch (InterruptedException e1) {
	        e1.printStackTrace();
	      }
	    }//end if  
}
/**
 * 检测两个球是否碰撞，一个吃掉另一个，返回 1；
 * @param p1
 * @param e1
 */
default int isCollition(Player p1,Enemy e1)
{
  double q = (e1.x+e1.w/2 - p1.x-p1.w/2)* (e1.x+e1.w/2 - p1.x-p1.w/2) ;
  double w = (e1.y +e1.w/2-p1.y-p1.w/2)* (e1.y +e1.w/2-p1.y-p1.w/2)  ;
  double n = q+ w;
  
  // n 是两个圆半径之和，就是相撞
  if (Math.sqrt(n) <= (e1.w +p1.w)/2)   {// start if 
//	  	e1.w += p1.w;
//     	e1.h += p1.h;
//   		p1.w = 0;
//   		p1.h = 0;
   		
   		//播放一段声音
		  
   		 	 	String fileName = "//Users/apple/4g.wav";
   		 	playSound(fileName);
   		 	if (p1.w < e1.w) {
				return 1;//player is dead
			}
   		 		p1.w = p1.w + e1.w;
   		 		p1.h = p1.h + e1.h;
   		 		e1.setState(false);
   		 		return 2;
  		}// end if 
   		 		
   		 		
   		 		return 0;

}
/**
 *  播放声音
 * @param fileName
 */
default void playSound(String fileName){
	File file = new File(fileName);
		AudioInputStream stream = null;
	try {
		stream = AudioSystem.getAudioInputStream(file);
	} catch (UnsupportedAudioFileException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
AudioFormat format = stream.getFormat();
DataLine.Info info = new DataLine.Info(Clip.class, format);
Clip clip = null;
try {
clip = (Clip)AudioSystem.getLine(info);
} catch (LineUnavailableException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
clip.open(stream);
} catch (LineUnavailableException | IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
clip.start();//end playSound
	
}// end if playSound;

default void gameOver(Graphics g){
	
	//pictureDrawer.frame.dispose();
  	g.setColor(new Color(20, 160, 40));
		g.setFont(new Font("Serif", Font.BOLD, 96));
	g.drawString("Game Over", 300, 300);
	//@SuppressWarnings("unused")
	//frame2 b = new frame2();
}
}

