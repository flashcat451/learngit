import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author BIG BROTHER
 *
 */

/**
 * 
 * FirstTry 整个游戏的主窗口
 *
 */
public class FirstTry extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 构造函数，设定窗口大小、空布局、背景色
	 */
	public FirstTry() {
		this.setSize(400, 400);
		this.setTitle("Mr.Gulp");
		this.setLocation(100, 100);
		this.setLayout(null);
		this.setBackground(Color.getHSBColor(100, 30, 30));
		JPanel jp = (JPanel)this.getContentPane();
		
		/**
		 * 把面板设置成透明？以便backGround显示出来
		 */
		jp.setOpaque(false);
		//BackgroundPanel kk = new BackgroundPanel();

		JButton m = new JButton("start");
		JButton n = new JButton("close");
		JButton jason = new JButton("Lets move the circle!");
		jason.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jason){
					FirstTry.this.dispose();
					//本窗口删除，调用 新的对象 pictureDrawer();
					new PictureDrawer();
				}
			}
		});
		n.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == n) {
				System.exit(0);
				}
			}
		});
		
		m.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == m){
					FirstTry.this.dispose();
					frame2 fram2 = new frame2();
					fram2.setVisible(true);
				}	
			}
			
		});
		
		m.setLocation(170,100);
		m.setSize(50, 50);
		n.setLocation(170, 200);
		n.setSize(50, 50);
		jason.setLocation(120,150);
		jason.setSize(150, 50);
		this.add(jason);
		this.add(m);
		this.add(n);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FirstTry a = new FirstTry();
	}
		
}
