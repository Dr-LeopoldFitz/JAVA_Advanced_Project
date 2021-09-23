package AWT_Test;

import java.awt.*;
import java.net.*;
import javax.swing.*;

/**
 * @author Hive
 * Description:显示图片
 * Date: 2021/9/23 16:40
 */

public class DrawImage extends JFrame {
    Image img;
    public DrawImage() {
        URL imgUrl = DrawImage.class.getResource("bilibili_awk.png");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图片资源
        this.setSize(530, 550); // 设置窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        add(new CanvasPanel()); // 设置窗体面板为绘图面板对象
        this.setTitle("绘制图片"); // 设置窗体标题
    }
    public static void main(String[] args) {
        new DrawImage().setVisible(true);
    }
    class CanvasPanel extends Canvas {
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(img, 0, 0, this); // 显示图片
        }
    }
}