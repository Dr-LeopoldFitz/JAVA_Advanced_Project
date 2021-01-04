package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:Absolute Position Test
 * Date: 2021/1/3 12:23
 */
public class AbsolutePosition extends JFrame{
    public AbsolutePosition(){
        setTitle("Use AbsolutePosition");
        setLayout(null);
        setBounds(990-300,540-100,400,200);

        Container con=getContentPane();
        JButton jb1=new JButton("Button 1");
        JButton jb2=new JButton("Button 2");
        jb1.setBounds(50,30,90,30);
        jb2.setBounds(200,50,90,80);

        con.add(jb1);
        con.add(jb2);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AbsolutePosition();
    }
}
