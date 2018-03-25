import javax.swing.JFrame;
import javax.swing.border.*;
import java.awt.*;
/**
 * Javadoc EvangelionEffects
 * @author ic141202
 */
public class Emergency extends JFrame{
	public Emergency() {
		this.setTitle("EMERGENCY");
		this.setContentPane(new MyPanel());
		this.setPreferredSize(new Dimension(500, 500));
		this.setLocation(0, 0);
		
		this.setAlwaysOnTop(true);
		
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Emergency();
		
	//	playMusic mp = new playMusic();
	}
}