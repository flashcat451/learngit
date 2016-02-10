

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frame2 extends JFrame{
//	public static JPanel GImage = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	public frame2(){
		this.setSize(400, 400);
		this.setLocation(100, 100);
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setResizable(false);
		JPanel jp = (JPanel)this.getContentPane();
		jp.setOpaque(false);
		JLabel m = new JLabel("the GAME is ON");
		m.setSize(100, 100);
		m.setLocation(150, 125);
		this.add(m);
		Icon icon = new ImageIcon("／64.jpg");
		JButton back = new JButton("start", icon );
		back.setSize(100, 50);
		back.setLocation(150, 200);
		this.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == back){
					dispose();
					new FirstTry();
				}
					
			}
		});
		
		
		JLabel jb = new JLabel(icon);
		jb.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		jb.setLocation(0, 0);
		this.add(jb);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		//frame2 b = new frame2();
		


		
//		ImageIcon imageIcon = new ImageIcon(new ImageIcon("64m.jpg").getImage()
//		.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
//		JLabel jlblImageViewer =new JLabel();
//		jlblImageViewer.setIcon(imageIcon);
//		jlblImageViewer.setHorizontalAlignment(SwingConstants.CENTER);
//		b.add(jlblImageViewer, BorderLayout.CENTER);
		
//		String path = b.getClass().getResource("64.jpg").getPath();
//		ImageIcon pic = new ImageIcon(path);
//		JLabel back = new JLabel(pic);
//		back.setBounds(0, 0, pic.getIconWidth(), pic.getIconHeight());
//		b.add(back);
	}

}
