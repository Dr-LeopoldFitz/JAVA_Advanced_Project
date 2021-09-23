package AWT_Test;

import java.awt.*;
import javax.swing.*;

/**
 * @author Hive
 * Description:绘制五环
 * Date: 2021/9/23 13:26
 */

public class DrawCircle extends JFrame {
    private final int OVAL_WIDTH = 80;// 圆形的宽
    private final int OVAL_HEIGHT = 80;// 圆形的高
    public DrawCircle() {
        this.setTitle("绘制五环");
        this.setSize(300, 200);// 设置窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭模式
        setContentPane(new DrawPanel());// 设置窗体面板为绘图面板对象
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DrawCircle();
    }
    // 创建绘图面板
    class DrawPanel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            g.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第1个圆形
            g.drawOval(80, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第2个圆形
            g.drawOval(150, 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第3个圆形
            g.drawOval(50, 70, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第4个圆形
            g.drawOval(120, 70, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第5个圆形
        }
    }
}

