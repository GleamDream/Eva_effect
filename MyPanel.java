import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.imageio.ImageIO;

class MyPanel extends JPanel implements Runnable, KeyListener{
	final private String imgStr = "Emergency.png";
	final private int sp = 191;
	private int c = 0;
	private int x = 0;
	private int y = 0;
	private Image img;
	
	public MyPanel() {
		setBackground(new Color(0, 0, 0, 0));
		try {
			img = ImageIO.read(new File(imgStr));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addKeyListener(this);
		Thread refresh = new Thread(this);
		refresh.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		requestFocusInWindow();
		super.paintComponent(g);
		for (int i = 0; i < 150; i++) {
			HexagonPrint(g, i / 15, i % 15);
		}
	}
	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void HexagonPrint(Graphics g, int x, int y) {
		this.x = x;
		this.y = y;
		final int in = 56;
		final int ie = 96;
		int xd, yd;
		int r = (int)(Math.random() * 98963) % 10;
		if (y % 2 == 0 ) {
			xd = sp * x;
			yd = y * in - in;
			if (r > 3)
				g.drawImage(img, sp * x, y * in - in, 120, 110, this);
		}
		else {
			xd = sp * x - ie;
			yd = y * in - in;
			if (r > 3) 
				g.drawImage(img, sp * x - ie, y * in - in, 120, 110, this);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if (keycode == 27) {
			System.exit(0);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.exit(0);
	}
	@Override
	public void keyTyped(KeyEvent e) {}
}