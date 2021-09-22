package AdvancedEvent_Test;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Hive
 * Description:演示鼠标事件
 * Description:首先将光标移入窗体，然后单击鼠标左键，接着双击鼠标左键，最后将光标移出窗体
 * Date: 2021/9/22 20:19
 */


public class MouseEventTest extends JFrame {
    public static void main(String[] args) {
        MouseEventTest frame = new MouseEventTest();
        frame.setVisible(true);
    }

    public MouseEventTest() {
        super();
        setTitle("鼠标事件示例");
        setBounds(100, 100, 500, 375);
        // 设置窗体关闭按钮的动作为退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {// 光标移入组件时被触发
                System.out.println("光标移入组件");
            }

            public void mousePressed(MouseEvent e) {// 鼠标按键被按下时被触发
                System.out.print("鼠标按键被按下，");
                int i = e.getButton(); // 通过该值可以判断按下的是哪个键
                if (i == MouseEvent.BUTTON1)
                    System.out.println("按下的是鼠标左键");
                if (i == MouseEvent.BUTTON2)
                    System.out.println("按下的是鼠标滚轮");
                if (i == MouseEvent.BUTTON3)
                    System.out.println("按下的是鼠标右键");
            }

            public void mouseReleased(MouseEvent e) {// 鼠标按键被释放时被触发
                System.out.print("鼠标按键被释放，");
                int i = e.getButton(); // 通过该值可以判断释放的是哪个键
                if (i == MouseEvent.BUTTON1)
                    System.out.println("释放的是鼠标左键");
                if (i == MouseEvent.BUTTON2)
                    System.out.println("释放的是鼠标滚轮");
                if (i == MouseEvent.BUTTON3)
                    System.out.println("释放的是鼠标右键");
            }

            public void mouseClicked(MouseEvent e) {// 发生单击事件时被触发
                System.out.print("单击了鼠标按键，");
                int i = e.getButton(); // 通过该值可以判断单击的是哪个键
                if (i == MouseEvent.BUTTON1)
                    System.out.print("单击的是鼠标左键，");
                if (i == MouseEvent.BUTTON2)
                    System.out.print("单击的是鼠标滚轮，");
                if (i == MouseEvent.BUTTON3)
                    System.out.print("单击的是鼠标右键，");
                int clickCount = e.getClickCount();
                System.out.println("单击次数为" + clickCount + "下");
            }

            public void mouseExited(MouseEvent e) {// 光标移出组件时被触发
                System.out.println("光标移出组件");
            }
        });
        getContentPane().add(label, BorderLayout.CENTER);
    }

}
