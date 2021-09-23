package AdvancedEvent_Test;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Hive
 * Description:设计一个只允许输入数字的文本框，通过捕获文本框的键盘事件实现
 * Date: 2021/9/23 12:57
 */

public class NumOnlyTextField extends JFrame {

    private JTextField textField_1;
    private JTextField textField;

    public static void main(String[] args) {
        try {
            NumOnlyTextField frame = new NumOnlyTextField();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NumOnlyTextField() {
        super();
        setTitle("只允许输入数字");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        final JLabel label = new JLabel();
        label.setText("方式一：");
        panel.add(label);

        textField = new JTextField();
        textField.addKeyListener(new KeyListener() {
            int keyCode;
            public void keyPressed(KeyEvent e) {
                keyCode = e.getKeyCode();
            }

            public void keyTyped(KeyEvent e) {
                if (keyCode < KeyEvent.VK_0 || keyCode > KeyEvent.VK_9)
                    e.consume();
            }
            public void keyReleased(KeyEvent e) { }

        });
        textField.setColumns(20);
        panel.add(textField);

        final JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        final JLabel label_1 = new JLabel();
        label_1.setText("方式二：");
        panel_1.add(label_1);

        textField_1 = new JTextField();
        textField_1.addKeyListener(new KeyAdapter() {
            String num = "0123456789";
            public void keyTyped(KeyEvent e) {
                if (num.indexOf(e.getKeyChar()) < 0)
                    e.consume();
            }
        });
        textField_1.setColumns(20);
        panel_1.add(textField_1);
    }
}
