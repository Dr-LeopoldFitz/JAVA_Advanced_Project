package AdvancedEvent_Test;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/**
 * @author Hive
 * Description:窗体状态变化事件
 * Date: 2021/9/22 21:52
 */

public class WindowStateTest extends JFrame {
    public static void main(String[] args) {
        WindowStateTest frame = new WindowStateTest();
        frame.setVisible(true);
    }
    public WindowStateTest() {
        super();
        setTitle("捕获窗体状态事件");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowStateListener(new WindowStateListener(){
            public void windowStateChanged(WindowEvent e) {
                int oldState = e.getOldState();// 获得窗体以前的状态
                int newState = e.getNewState();// 获得窗体现在的状态
                String from = "";// 标识窗体以前状态的中文字符串
                String to = "";// 标识窗体现在状态的中文字符串
                switch (oldState) {// 判断窗台以前的状态
                    case Frame.NORMAL:// 窗体处于正常化
                        from = "正常化";
                        break;
                    case Frame.MAXIMIZED_BOTH:// 窗体处于最大化
                        from = "最大化";
                        break;
                    default:// 窗体处于最小化
                        from = "最小化";
                }
                switch (newState) {// 判断窗台现在的状态
                    case Frame.NORMAL:// 窗体处于正常化
                        to = "正常化";
                        break;
                    case Frame.MAXIMIZED_BOTH:// 窗体处于最大化
                        to = "最大化";
                        break;
                    default:// 窗体处于最小化
                        to = "最小化";
                }
                System.out.println(from + "—>" + to);
            }
        });
    }
}
