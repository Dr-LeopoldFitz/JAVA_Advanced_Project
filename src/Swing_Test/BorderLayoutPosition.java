package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:Border Layout Position Test
 * Date: 2021/1/3 16:56
 */

public class BorderLayoutPosition extends JFrame{
    String[] border = { BorderLayout.CENTER, BorderLayout.NORTH,
            BorderLayout.SOUTH, BorderLayout.WEST, BorderLayout.EAST };
    String[] buttonName = { "Center Button", "North Button",
            "South Button", "West Button", "East Button" };
    public BorderLayoutPosition(){
        setTitle("这个窗体使用边界布局管理器");
        Container con=getContentPane();
        setLayout(new BorderLayout());
        for(int i=0;i<border.length;i++){
            con.add(border[i],new JButton(buttonName[i]));
        }
        //con.add(BorderLayout.NORTH,new JButton("NORTH 2"));
        setSize(500,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderLayoutPosition();
    }
}
