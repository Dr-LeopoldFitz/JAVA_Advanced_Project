package AWT_Test;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * @author Hive
 * Description: 图片旋转
 * Date: 2021/9/23 20:04
 */

public class ImageRotate extends JFrame {
    private Image img;
    private MyCanvas canvasPanel = null;
    public ImageRotate() {
        URL imgUrl = ImageRotate.class.getResource("bilibili_awk.png");
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图片资源
        canvasPanel = new MyCanvas();
        this.setBounds(0, 0, 800, 800); // 设置窗体大小和位置
        add(canvasPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        this.setTitle("图片旋转"); // 设置窗体标题
    }

    public static void main(String[] args) {
        new ImageRotate().setVisible(true);
    }
    // 画板
    class MyCanvas extends JPanel {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(Math.toRadians(10));
            g2.drawImage(img, 250, 0, 512, 512, this);
            g2.rotate(Math.toRadians(10));
            g2.drawImage(img, 250, 0, 512, 512, this);
            g2.rotate(Math.toRadians(10));
            g2.drawImage(img, 250, 0, 512, 512, this);
        }
    }
}