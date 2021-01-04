package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:JPanel Test
 * Date: 2021/1/4 11:38
 */

public class JPanelTest extends JFrame{
    public JPanelTest(){
        Container con=getContentPane();
        con.setLayout(new GridLayout(2,3,10,10));

        JPanel p1=new JPanel(new GridLayout(1,3,10,10));
        JPanel p2=new JPanel(new GridLayout(1,2,10,10));
        JPanel p3=new JPanel(new GridLayout(1,2,10,10));
        JPanel p4=new JPanel(new GridLayout(2,1,10,10));

        p1.add(new JButton("1"));
        p1.add(new JButton("2"));
        p1.add(new JButton("3"));

        p2.add(new JButton("4"));
        p2.add(new JButton("5"));

        p3.add(new JButton("6"));
        p3.add(new JButton("7"));

        p4.add(new JButton("8"));
        p4.add(new JButton("9"));

        con.add(p1);
        con.add(p2);
        con.add(p3);
        con.add(p4);

        setTitle("此窗体使用JPanel面板");
        setSize(420,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelTest();
    }
}
