package Swing_Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * @author Hive
 * Description:Create JDialog
 * Date: 2021/1/2 21:33
 */

class MyJDialog extends JDialog{
    public MyJDialog(JDialogTest frame){
        super(frame,"第一个JDialog窗体",true);
        Container con=getContentPane();
        con.add(new JLabel("这是一个对话框"));
        setBounds(120,120,100,100);
    }
}

public class JDialogTest extends JFrame{
    public static void main(String[] args){
        new JDialogTest();
    }

    public JDialogTest(){
        Container con=getContentPane();
        con.setLayout(null);
        JLabel jl=new JLabel("这是一个JFrame窗体");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        con.add(jl);
        JButton jb=new JButton("弹出对话框");
        jb.setBounds(10,10,100,21);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MyJDialog(JDialogTest.this).setVisible(true);
            }
        });
        con.add(jb);
        con.setBackground(Color.white);
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
