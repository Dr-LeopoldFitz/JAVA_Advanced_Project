package Swing_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Hive
 * Description:
 * Date: 2021/1/4 17:27
 */
public class JTextFieldTest extends JFrame{
    public JTextFieldTest(){
        setSize(250,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container con=getContentPane();
        con.setLayout(new FlowLayout());
        final JTextField jtf=new JTextField("Alveus means Hive",20);
        final JButton jb=new JButton("Clear");

        con.add(jtf);
        con.add(jb);
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("触发事件");
            }
        });
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText(""); //文本框置空
                jtf.requestFocus(); //焦点回到文本框
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new JTextFieldTest();
    }
}
