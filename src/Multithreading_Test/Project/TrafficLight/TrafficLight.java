package Multithreading_Test.Project.TrafficLight;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

/**
 * @author Hive
 * Description:模拟红绿灯变化场景:红灯亮8秒，绿灯亮5秒，黄灯亮2秒
 * Date: 2021/9/24 14:19
 */

public class TrafficLight extends JFrame { // 创建一个“交通灯”类，并继承JFrame
    private JPanel contentPane; // 内容面板
    private JLabel lblImage; // 图片标签

    public static void main(String[] args) {
        TrafficLight frame = new TrafficLight(); // 创建“交通灯”窗体对象
        frame.setVisible(true); // 使“交通灯”窗体对象可视
    }

    /**
     * 创建窗体
     */
    public TrafficLight() { // “交通灯”的构造方法
        setResizable(false); // 不可改变窗体的大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭的方式
        setBounds(100, 100, 125, 278); // 设置窗体大小，位置
        // 内容面板
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setContentPane(contentPane);
        // 图片面板
        JPanel imagePane = new JPanel();
        imagePane.setBackground(Color.WHITE);
        imagePane.setBorder(new TitledBorder(null, "交通灯", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(imagePane);
        imagePane.setLayout(new BorderLayout(0, 0));
        // 标签
        lblImage = new JLabel("");
        lblImage.setBackground(Color.WHITE);
        lblImage.setIcon(new ImageIcon(TrafficLight.class.getResource("Green.png")));
        imagePane.add(lblImage, BorderLayout.CENTER);

        Thread thread = new TurnColor(lblImage); // 创建线程类的子类之“改变颜色”的对象
        thread.start(); // 启用线程
    }
}

class TurnColor extends Thread { // 创建“改变颜色”类继承线程类
    private JLabel lblImage; // 图像标签

    public TurnColor(JLabel lblImage) { // 以图像标签为参数的构造方法，利用构造方法初始化变量
        this.lblImage = lblImage;
    }

    @Override
    public void run() { // 线程执行的任务
        while (true) { // 线程始终处于被启用状态
            try {
                Thread.sleep(5000); // 线程休眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TrafficLight.class.getResource("Yellow.png"))); // 黄灯
            try {
                Thread.sleep(2000); // 线程休眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TrafficLight.class.getResource("Red.png"))); // 红灯
            try {
                Thread.sleep(8000); // 线程休眠8秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TrafficLight.class.getResource("Green.png"))); // 绿灯
        }
    }
}