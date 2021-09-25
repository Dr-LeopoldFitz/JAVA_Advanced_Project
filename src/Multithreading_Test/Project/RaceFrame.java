package Multithreading_Test.Project;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * @author Hive
 * Description: 模拟龟兔赛跑，兔子跑70米时开始睡觉，乌龟到终点时兔子继续跑
 * Date: 2021/9/24 14:30
 */

public class RaceFrame extends JFrame {

    private JPanel contentPane;
    private JTextArea rabbitTextArea;
    private JTextArea tortoiseTextArea;
    Runnable runRabbit = new Rabbit();
    Runnable runTortoise = new Tortoise();
    Thread rabbit = new Thread(runRabbit);
    Thread tortoise = new Thread(runTortoise);

    public static void main(String[] args) {
        RaceFrame frame = new RaceFrame();
        frame.setVisible(true);
    }

    public RaceFrame() {
        setTitle("龟兔赛跑");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton button = new JButton("比赛开始");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_button_actionPerformed(arg0);
            }
        });
        buttonPanel.add(button);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 2, 5, 5));

        JPanel rabbitPanel = new JPanel();
        panel.add(rabbitPanel);
        rabbitPanel.setLayout(new BorderLayout(0, 0));

        JLabel rabbitLabel = new JLabel("兔子的比赛记录");
        rabbitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rabbitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rabbitPanel.add(rabbitLabel, BorderLayout.NORTH);

        JScrollPane rabbitScrollPane = new JScrollPane();
        rabbitPanel.add(rabbitScrollPane, BorderLayout.CENTER);

        rabbitTextArea = new JTextArea();
        rabbitTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rabbitScrollPane.setViewportView(rabbitTextArea);

        JPanel tortoisePanel = new JPanel();
        panel.add(tortoisePanel);
        tortoisePanel.setLayout(new BorderLayout(0, 0));

        JLabel tortoiseLabel = new JLabel("乌龟的比赛记录");
        tortoiseLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tortoiseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tortoisePanel.add(tortoiseLabel, BorderLayout.NORTH);

        JScrollPane tortoiseScrollPane = new JScrollPane();
        tortoisePanel.add(tortoiseScrollPane, BorderLayout.CENTER);

        tortoiseTextArea = new JTextArea();
        tortoiseTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tortoiseScrollPane.setViewportView(tortoiseTextArea);
    }

    protected void do_button_actionPerformed(ActionEvent arg0) {
        rabbit.start();
        tortoise.start();
    }

    private class Rabbit implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {// 循环10次模拟赛跑的过程
                String text = rabbitTextArea.getText();// 获得文本域中的信息
                try {
                    Thread.sleep(100);// 线程休眠0.1秒，模拟兔子在跑步
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rabbitTextArea.setText(text + "兔子跑了" + i + "0米\n");// 显示兔子的跑步距离
                if (i == 7) {
                    rabbitTextArea.setText(text + "兔子在睡觉\n");// 当跑了90米时开始睡觉
                    try {
                        tortoise.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 10) {
                    rabbitTextArea.setText(text + "兔子到达终点\n");// 显示兔子到达了终点
                }
            }
        }
    }

    private class Tortoise implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                String text = tortoiseTextArea.getText();
                try {
                    Thread.sleep(500);// 线程休眠0.5秒，模拟乌龟在跑步
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tortoiseTextArea.setText(text + "乌龟跑了" + i + "0米\n");
                if (i == 10) {
                    tortoiseTextArea.setText(text + "乌龟到达终点\n");
                }
            }
        }
    }
}
