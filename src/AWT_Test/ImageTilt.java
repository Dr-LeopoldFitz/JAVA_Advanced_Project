package AWT_Test;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * @author Hive
 * Description:图像倾斜
 * Date: 2021/9/23 20:14
 */

public class ImageTilt extends JFrame {
    private Image img;
    private MyCanvas canvasPanel = null;
    public ImageTilt() {
        URL imgUrl = ImageTilt.class.getResource("bilibili_awk.png");
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图片资源
        canvasPanel = new MyCanvas();
        this.setBounds(0, 0, 800, 800); // 设置窗体大小和位置
        add(canvasPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        this.setTitle("图片倾斜"); // 设置窗体标题
    }

    public static void main(String[] args) {
        new ImageTilt().setVisible(true);
    }
    // 画板
    class MyCanvas extends JPanel {
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.shear(0.3, 0.3);
            g2.drawImage(img, 0, 0, 512, 512, this);// 绘制指定大小的图片
        }
    }
}