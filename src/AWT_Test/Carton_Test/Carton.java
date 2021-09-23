package AWT_Test.Carton_Test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Carton extends JFrame {
	private JPanel panel;
	public static void main(String[] args) {
		try {
			Carton frame = new Carton();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Carton() {
		super();
		setBounds(0, 0, 1200, 730);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
	}
	protected JPanel getPanel() {
		if (panel == null) {
			panel = new CanvasPanel();
		}
		return panel;
	}

}
