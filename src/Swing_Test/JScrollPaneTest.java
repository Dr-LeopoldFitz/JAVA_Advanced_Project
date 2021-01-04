package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:JScrollPane Test
 * Date: 2021/1/4 12:09
 */
public class JScrollPaneTest extends JFrame{
    public JScrollPaneTest(){
        Container con=getContentPane();
        JTextArea jta=new JTextArea(20,50);
        jta.append(" Hail To The New World Order ! ");
        JScrollPane jsp=new JScrollPane(jta);
        con.add(jsp);

        setTitle("JScrollPane测试-带滚动条的文字编辑器");
        setSize(400,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollPaneTest();
    }
}
