package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:JRadioButton & ButtonGroup Test
 * Date: 2021/1/4 14:25
 */
public class JRadioButtonTest extends JFrame{
    private JRadioButton rb1=new JRadioButton("A");
    private JRadioButton rb2=new JRadioButton("B");
    private JRadioButton rb3=new JRadioButton("C");

    private JRadioButton rb4=new JRadioButton("D");
    private JRadioButton rb5=new JRadioButton("E");

    ButtonGroup bg=new ButtonGroup();

    public JRadioButtonTest(){
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        Container con=getContentPane();
        con.setLayout(new GridLayout(2,0,5,5));
        // con.add(bg);
        // 错误，ButtonGroup只是绑定JRadioButton，要frame中出现JRadioButton，要重新add
        con.add(rb1);
        con.add(rb2);
        con.add(rb3);

        con.add(rb4);
        con.add(rb5);
        //rb 1-3 为一组，只能选中其中之一 rb 4，5分别单独成组，可同时选中或不选中
        setTitle("JRadioButton测试");
        setSize(400,150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JRadioButtonTest();
    }
}
