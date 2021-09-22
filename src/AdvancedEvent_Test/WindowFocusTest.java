package AdvancedEvent_Test;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 * @author Hive
 * Description:窗口焦点事件
 * Date: 2021/9/22 21:22
 */

public class WindowFocusTest extends JFrame {
    public static void main(String[] args) {
        WindowFocusTest frame = new WindowFocusTest();
        frame.setVisible(true);
    }
    public WindowFocusTest() {
        super();
        setTitle("捕获窗体焦点事件");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowFocusListener(new WindowFocusListener(){
            public void windowGainedFocus(WindowEvent e) {// 窗口获得焦点时被触发
                System.out.println("窗口获得了焦点！");
            }
            public void windowLostFocus(WindowEvent e) {// 窗口失去焦点时被触发
                System.out.println("窗口失去了焦点！");
            }
        });
    }
}
