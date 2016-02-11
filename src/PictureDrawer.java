import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

public class PictureDrawer extends JPanel  implements Runnable, MouseListener,function,ActionListener
{
  private static final long serialVersionUID = 1L;
  public PictureDrawer()
  {
	  this.frame.setSize(1000, 600);
	  this.frame.setLocation(100, 100);
	  this.frame.setTitle("开始游戏----");
	  this.frame.setDefaultCloseOperation(3);
	  this.frame.setResizable(false);
	  //Menu settings
	  JMenuBar menubar1 = new JMenuBar();
	  JMenuItem item1 = new JMenuItem("BACK 2 MENU");
	  JMenuItem item2 = new JMenuItem("QUIT");
	  JMenuItem item3 = new JMenuItem("LEADERBOARD");
	  
	  JMenu menu1 = new JMenu("MENU");
	  this.frame.setJMenuBar(menubar1);
	 menubar1.add(menu1);
	 menu1.add(item1);
	 menu1.add(item2);
	 menu1.add(item3);
	 item1.addActionListener(this);
	 item1.setActionCommand("r");
	 item2.addActionListener(this);
	 item2.setActionCommand("q");
	 item3.addActionListener(this);
	 item3.setActionCommand("l");
	 
	 
	 

	  
	  this.frame.add(this);
	  setFocusable(true);
	  addMouseListener(this);
	  //this.enemyBall = new Enemy(120, 50, 60, 60,Color.red);
	  this.yellowBall = new Player(500, 300, 50, 50,Color.yellow);
	  eInitialize();
	  
	  Thread nThread = new Thread(this);
	  nThread.start();
	  
	  this.frame.setVisible(true);
  }
  //Enemy Initialize
  Enemy enemies[] = new Enemy[8];
  public void eInitialize(){
	  enemies[0] = new Enemy(120, 130, 10, 10, new Color(18));
	  enemies[1] = new Enemy(180, 30, 40, 40, new Color(19));
	  enemies[2] = new Enemy(550, 77, 70, 70, new Color(20));
	  enemies[3] = new Enemy(700, 45, 20, 20, new Color(21));
	  enemies[4] = new Enemy(5, 550, 5, 5, new Color(22));
	  enemies[5] = new Enemy(300, 400, 55, 55, new Color(17));
	  enemies[6] = new Enemy(750, 230, 35, 35, new Color(16));
	  enemies[7] = new Enemy(900, 500, 80, 80, new Color(8));
  }
  
 // public Enemy enemyBall;
  public Player yellowBall;
  private int mouseClickX;
  private int mouseClickY;
  private int score;

  
  JFrame frame = new JFrame();
  int gameOver = 0;
  boolean leaderBoarding = false;//Whether the panel is displaying the highscores

//菜单栏
@Override
public void actionPerformed(ActionEvent e) {
	switch (e.getActionCommand().charAt(0)) {
	case 'r':
		this.frame.dispose();
		new FirstTry();
		break;
	case 'q':
		this.frame.dispose();
		break;
	case'l':
		leaderBoarding = true;
		
		break;
	}
	
}
  
  
  
  
  
  
  Font font = new Font("Impact", Font.BOLD, 40);
  public void paint(Graphics g)
  {
	 
	  super.paint(g);
	  g.setColor(new Color(151));
	  g.fillRect(0, 0, 1000, 600);
	
	  if(gameOver !=1 && !leaderBoarding){
    
    drawPlayer(g, this.yellowBall, yellowBall.color);
    
    for(Enemy eachEnemy:enemies){
    if(isCollition(yellowBall, eachEnemy) == 2)
    		score += 20;
    }
    g.setFont(font);
    g.setColor(Color.WHITE);
    g.drawString("SCORE: " + score, 20, 550);
    
    for(Enemy eachEnemy:enemies){
    		eachEnemy.randMove();
    
    		drawPlayer(g, eachEnemy, eachEnemy.color);
    		// ate();
    		gameOver=isCollition(yellowBall, eachEnemy);
    }
	  }// end if
	 // g.setFont();
	  else if(gameOver == 1 && !leaderBoarding){
		  gameOver(g);
	  }
	  else if(leaderBoarding){
		  Scores scores = new Scores();
		  scores.displayScores(g);
	  }
    	
    }
  


/**
 * 应该再加一个判断，是谁吃谁。小的被大的吃
 */
 
	  
//  public void ate()
//  {
//    double q = Math.pow(this.enemyBall.x+this.enemyBall.w - this.yellowBall.x-this.yellowBall.w, 2.0D);
//    double w = Math.pow(this.enemyBall.y +this.enemyBall.w- this.yellowBall.y-this.yellowBall.w, 2.0D);
//    double n = q + w;
//    if (Math.sqrt(n) <= this.enemyBall.w + this.yellowBall.w) {
//      this.enemyBall.w += this.yellowBall.w;
//      this.enemyBall.h += this.yellowBall.h;
//      this.yellowBall.w = 0;
//      this.yellowBall.h = 0;
//    }
//  }
/**
 * draw player or enemy in panel
 * @param g
 * @param player
 * @param color
 */
  public void drawPlayer(Graphics g, Player player, Color color)
  {
    g.setColor(color);
    g.fillOval(player.x, player.y, player.w, player.h);
  }

  public void run()
  {
    while (true)
    {
     	playerMoveToMouseClick(yellowBall, this); //黄球向着鼠标点击的方向跑
    	  
     	try {
     		Thread.sleep(5L);
     	}
      catch (InterruptedException e) {
        e.printStackTrace();
      }
     	paintImmediately(0, 0, getWidth(), getHeight());   	// repaint immediately----------------------------------------------------------------------
    }
  }

  public int getMouseClickX() {
    return this.mouseClickX;
  }

  public void setMouseClickX(int mouseClickX) {
    this.mouseClickX = mouseClickX;
  }

  public int getMouseClickY() {
    return this.mouseClickY;
  }

  public void setMouseClickY(int mouseClickY) {
    this.mouseClickY = mouseClickY;
  }
/**
 * mouseClick return getX & getY location
 */
  public void mouseClicked(MouseEvent e)
  {
    setMouseClickX(e.getX());
    setMouseClickY(e.getY());
  
  }

  public void mousePressed(MouseEvent e)
  {
  }

  public void mouseReleased(MouseEvent e)
  {
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }



    
  
}

