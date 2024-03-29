package AdvancedEvent_Test;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 * @author Hive
 * Description:
 * Date: 2021/9/22 22:18
 */

public class WindowChangingTest extends JFrame {
    public static void main(String[] args) {
        WindowChangingTest frame = new WindowChangingTest();
        frame.setVisible(true);
    }
    public WindowChangingTest() {
        super();
        setTitle("捕获其他窗体事件");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowListener(){
            public void windowActivated(WindowEvent e) {// 窗体被激活时触发
                System.out.println("窗口被激活！");
            }
            public void windowOpened(WindowEvent e) {// 窗体被打开时触发
                System.out.println("窗口被打开！");
            }
            public void windowIconified(WindowEvent e) {// 窗体被最小化时触发
                System.out.println("窗口被最小化！");
            }
            public void windowDeiconified(WindowEvent e) {// 窗体被非最小化时触发
                System.out.println("窗口被非最小化！");
            }
            public void windowClosing(WindowEvent e) {// 窗体将要被关闭时触发
                System.out.println("窗口将要被关闭！");
            }
            // 窗体不再处于激活状态时触发
            public void windowDeactivated(WindowEvent e) {
                System.out.println("窗口不再处于激活状态！");
            }
            public void windowClosed(WindowEvent e) {// 窗体已经被关闭时触发
                System.out.println("窗口已经被关闭！");
            }
        });// 为窗体添加其他事件监听器

    }

}