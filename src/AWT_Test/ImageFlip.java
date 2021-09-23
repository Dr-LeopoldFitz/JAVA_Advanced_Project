package AWT_Test;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * @author Hive
 * Description:图像翻转
 * Date: 2021/9/23 19:45
 */

public class ImageFlip extends JFrame {
    private Image img;
    private int dx1, dy1, dx2, dy2;
    private int sx1, sy1, sx2, sy2;
    private JPanel jPanel = null;
    private JPanel jPanel1 = null;
    private JButton jButton = null;
    private JButton jButton1 = null;
    private MyCanvas canvasPanel = null;

    public ImageFlip() {
        dx2 = sx2 = 512; // 初始化图像大小
        dy2 = sy2 = 512;
        URL imgUrl = ImageFlip.class.getResource("bilibili_awk.png");// 获取图片资源的路径
        img = Toolkit.getDefaultToolkit().getImage(imgUrl); // 获取图片资源
        this.setBounds(100, 100, 570, 600); // 设置窗体大小和位置
        this.setContentPane(getJPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭模式
        this.setTitle("图片翻转"); // 设置窗体标题
    }

    // 获取内容面板的方法
    private JPanel getJPanel() {
        if (jPanel == null) {
            jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout());
            jPanel.add(getControlPanel(), BorderLayout.SOUTH);
            jPanel.add(getMyCanvas(), BorderLayout.CENTER);
        }
        return jPanel;
    }

    // 获取按钮控制面板的方法
    private JPanel getControlPanel() {
        if (jPanel1 == null) {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            jPanel1 = new JPanel();
            jPanel1.setLayout(new GridBagLayout());
            jPanel1.add(getMyButton1(), new GridBagConstraints());
            jPanel1.add(getMyButton2(), gridBagConstraints);
        }
        return jPanel1;
    }

    // 获取水平翻转按钮
    private JButton getMyButton1() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setText("水平翻转");
            jButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    sx1 = Math.abs(sx1 - 512);
                    sx2 = Math.abs(sx2 - 512);
                    canvasPanel.repaint();
                }
            });
        }
        return jButton;
    }

    // 获取垂直翻转按钮
    private JButton getMyButton2() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setText("垂直翻转");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    sy1 = Math.abs(sy1 - 512);
                    sy2 = Math.abs(sy2 - 512);
                    canvasPanel.repaint();
                }
            });
        }
        return jButton1;
    }

    // 获取画板面板
    private MyCanvas getMyCanvas() {
        if (canvasPanel == null) {
            canvasPanel = new MyCanvas();
        }
        return canvasPanel;
    }

    // 主方法
    public static void main(String[] args) {
        new ImageFlip().setVisible(true);
    }

    // 画板
    class MyCanvas extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, this);// 绘制指定大小的图片
        }
    }
}