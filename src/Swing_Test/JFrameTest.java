package Swing_Test;

import java.awt.*;
import javax.swing.*;
/*
 * @author Hive
 * Description:Create JFrame
 * Date: 2021/1/2 19:03
 */

public class JFrameTest extends JFrame{
    public JFrameTest(String title){
        super(title);
    }
    public void Create(){
        Container con=getContentPane();
        JLabel jl=new JLabel("这是一个JFrame窗体");
        jl.setHorizontalAlignment(SwingConstants.CENTER);

        con.add(jl);
        con.setBackground(Color.orange);

        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFrameTest("新建JFrame窗体").Create();
    }
}