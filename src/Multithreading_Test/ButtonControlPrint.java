package Multithreading_Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Hive
 * Description:当用户单击“开始”按钮时，在控制台中持续打印一段话；当用户单击“停止”按钮时，控制台结束打印
 * Date: 2021/9/9 19:34
 */

public class ButtonControlPrint extends JFrame {

    private static final long serialVersionUID = 1L;
    JPanel jPanel1 = new JPanel();
    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    MyThread thread = null;
    private boolean isContinue;
    public ButtonControlPrint() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        startButton.setText("start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton_actionPerformed(e);
            }
        });
        stopButton.setText("stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopButton_actionPerformed(e);
            }
        });
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(startButton);
        startButton.setBounds(36, 105, 82, 30);
        jPanel1.add(stopButton);
        stopButton.setBounds(160, 108, 100, 31);
    }

    void startButton_actionPerformed(ActionEvent e) {
        if (thread != null)
            isContinue=false;
        thread = new MyThread();
        thread.start();
    }

    void stopButton_actionPerformed(ActionEvent e) {
        if (thread != null)
            isContinue=false;
        thread = null;
    }

    public static void main(String[] args) {
        ButtonControlPrint test = new ButtonControlPrint();
        test.setBounds(300,300,300, 80);
        test.setVisible(true);
    }

    private class MyThread extends Thread {
        public MyThread() {
            isContinue=true; //标志线程是否结束
        }

        public void run() {
            System.out.println("\n\n");
            while (true && isContinue) {
                System.out.println("Hive‘s Blog\thttps://www.cnblogs.com/alveus/");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

