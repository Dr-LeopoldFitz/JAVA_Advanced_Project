package AWT_Test.Carton_Test;

import java.awt.*;
import javax.swing.*;

public class CanvasPanel extends JPanel implements Runnable {
	private Image back;
	private Image emoji;
	int time;

	private Thread t1;
	private boolean play = true;

	int bwidth = 1200;
	int bheight = 730;
	int ewidth = 80;
	int eheight = 75;

	int x = bwidth;
	int y = 10;
	int e2=x-50;
	int e3=x+50;

	public CanvasPanel() {
		super();
		back = new ImageIcon(getClass().getResource("xinyi_back.png")).getImage();
		emoji = new ImageIcon(getClass().getResource("emo.png")).getImage();
		time = 30;
		play = true;
		if (t1 == null || !t1.isAlive()){
			t1 = new Thread(this);
		}
		t1.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, bwidth, bheight, this);

		g.drawImage(emoji, x, y, ewidth, eheight, this);
		g.drawImage(emoji, e2, y-75, ewidth, eheight, this);
		g.drawImage(emoji, e3, y+75, ewidth, eheight, this);

		x -= 8;
		e2-=3;
		e3-=5;
		y += 5;

		if (x <= -emoji.getWidth(this)||y >= bheight+emoji.getHeight(this)){
			x = bwidth;
			y = 10;
			e2 = x-50;
			e3 = x+50;
		}
	}
	public void run() {
		while (play) {
			try {
				Thread.sleep(time);
			} catch (Exception e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
}
