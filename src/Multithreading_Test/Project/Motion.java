package Multithreading_Test.Project;

/**
 * @author Hive
 * Description:使用Swing和线程实现●和★在窗体中做无规则运动
 * Date: 2021/9/24 14:35
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Motion extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        Motion motion = new Motion();
        motion.setVisible(true);
    }

    public Motion() {
        setResizable(false); // 不可改变窗体的大小
        setTitle("不规则运动的物体");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 376, 350); // 设置窗体的横、纵坐标，宽高

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // 充当运动区域的面板
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK, 1, true));
        panel.setBounds(10, 10, 350, 270);
        contentPane.add(panel);
        panel.setLayout(null);
        // 显示“圆点”的标签
        JLabel lblCircle = new JLabel("●");
        lblCircle.setBounds(27, 53, 15, 15);
        panel.add(lblCircle);
        // 显示“五角星”的标签
        JLabel lblStar = new JLabel("★");
        lblStar.setBounds(330, 189, 15, 15);
        panel.add(lblStar);
        // 创建以标签、面板为参数的线程对象
        MyThread circle = new MyThread("Circle",lblCircle, panel);
        MyThread star = new MyThread("Star",lblStar, panel);
        // “开始”按钮
        JButton btnStart = new JButton("开始");
        btnStart.setBounds(267, 290, 93, 23);
        contentPane.add(btnStart);
        btnStart.addActionListener(new ActionListener() { // 为“开始”按钮添加动作事件的监听
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (btnStart.getText().equals("开始")) { // 点击“开始”按钮时
                    circle.start();
                    star.start();
                    btnStart.setText("暂停");
                } else if (btnStart.getText().equals("暂停")) { // 点击“暂停”按钮时
                    circle.stopRun();
                    star.stopRun();
                    btnStart.setText("继续");
                } else if (btnStart.getText().equals("继续")) { // 点击“继续”按钮时
                    circle.goRun();
                    star.goRun();
                    btnStart.setText("暂停");
                }
            }
        });
    }
}

class MyThread extends Thread {
    boolean suspend = false; // 挂起线程的标志
    JLabel label; // 标签
    JPanel panel; // 面板

    public MyThread(String n,JLabel l, JPanel p) { // 以线程名、标签、面板为参数的构造方法
        super(n);
        label = l;
        panel = p;
    }

    synchronized void goRun() { // 继续运行
        suspend = false; // 终止“挂起区”循环
        notify(); // 唤醒等待（wait()）的线程
    }

    synchronized void stopRun() { // 暂停运行
        suspend = true; // 开启“挂起区”循环
    }

    @Override
    public void run() {
        int px = panel.getWidth() - label.getWidth(); // 横向最大边界
        int py = panel.getHeight() - label.getHeight(); // 纵向最大边界
        int xadd = 1, yadd = 1; // 坐标偏移量
        while (true) {
            synchronized (this) {// 挂起区
                while (suspend) {
                    System.out.println(this.getName()+" Suspend:" + suspend);
                    try {
                        wait(); // 挂起
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            int x = label.getX(); // 获取横坐标
            int y = label.getY(); // 获取纵坐标
            if (x <= 0 || x >= px) {// 判断是否到达边界
                xadd *= -1;// 换方向
            }
            if (y <= 0 || y >= py) {
                yadd *= -1;
            }
            label.setBounds(x + xadd, y + yadd, label.getWidth(), label.getHeight());
            // 重新设置字符位置
            try {
                Thread.sleep(8); // 利用线程的休眠控制图标的运行速度
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
