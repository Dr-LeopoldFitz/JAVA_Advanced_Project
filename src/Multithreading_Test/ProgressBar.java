package Multithreading_Test;

import java.awt.*;
import javax.swing.*;

/**
 * @author Hive
 * Description:在窗体中设计一个进度条，使进度条每次递增滚动。
 * Date: 2021/9/9 19:43
 */

public class ProgressBar extends JFrame {
    private static final long serialVersionUID = 1L;
    final JProgressBar progressBar = new JProgressBar();

    public ProgressBar() {

        getContentPane().add(progressBar, BorderLayout.NORTH);
        progressBar.setStringPainted(true);

        Thread threadA = new Thread(new Runnable() {
            int count = 0;
            public void run() {
                while (true) {
                    progressBar.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
    }

    public static void main(String[] args) {
        init(new ProgressBar(), 100, 100);
    }

    public static void init(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
