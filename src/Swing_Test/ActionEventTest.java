package Swing_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Hive
 * Description:ActionEvent Test
 * Date: 2021/1/4 18:08
 */

public class ActionEventTest extends JFrame{
    private JButton jb=new JButton("点击此按钮");
    public ActionEventTest(){
        setLayout(null);
        setSize(200,100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Container cp=getContentPane();
        cp.add(jb);
        jb.setBounds(10, 10,130,30);
        jb.addActionListener(new jbAction());
        setVisible(true);
    }
    class jbAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            jb.setText("按钮已被点击");
        }
    }
    public static void main(String[] args) {
        new ActionEventTest();
    }
}