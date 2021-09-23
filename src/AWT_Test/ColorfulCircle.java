package AWT_Test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Date;
import java.awt.*;

/**
 * @author Hive
 * Description: 彩色五环
 * Date: 2021/9/23 20:23
 */

public class ColorfulCircle extends JFrame {
    private JPanel panel;
    public static void main(String[] args) {
        try {
            ColorfulCircle frame = new ColorfulCircle();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ColorfulCircle() {
        super();
        setBounds(100, 100, 458, 357);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(getPanel(), BorderLayout.CENTER);
    }
    protected JPanel getPanel() {
        if (panel == null) {
            panel = new MyPanel();
        }
        return panel;
    }

}

class MyPanel extends JPanel {

    private static final int OVAL_WIDTH = 150;
    private static final int OVAL_HEIGHT = 150;

    public MyPanel() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4.0F));
        g2.setColor(Color.BLUE);
        g2.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第1个圆形
        g2.setStroke(new BasicStroke(8.0F));
        g2.setColor(Color.CYAN);
        g2.drawOval(130, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第2个圆形
        g2.setStroke(new BasicStroke(2.0F));
        g2.setColor(Color.GREEN);
        g2.drawOval(250, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第3个圆形
        g2.setStroke(new BasicStroke(5.0F));
        g2.setColor(Color.MAGENTA);
        g2.drawOval(70, 120, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第4个圆形
        g2.setStroke(new BasicStroke(9.0F));
        g2.setColor(Color.ORANGE);
        g2.drawOval(190, 120, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第5个圆形
        Date now=new Date();
        String nowStr = String.format("%tY年%tm月%td日", new Date[]{now, now, now});
        Font font = new Font("黑体",Font.BOLD,14);
        g2.setFont(font);
        g2.drawString(nowStr, 150, 300);
    }

}
