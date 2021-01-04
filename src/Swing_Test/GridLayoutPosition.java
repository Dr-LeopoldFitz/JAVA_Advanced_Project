package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:GridLayout Position Test
 * Date: 2021/1/3 17:17
 */
public class GridLayoutPosition extends JFrame{
    public GridLayoutPosition(){
        Container con=getContentPane();
        setLayout(new GridLayout(7,3,5,5));
        for(int i=0;i<20;i++){
            con.add(new JButton("Button"+i));
        }
        setSize(500,300);
        setTitle("这是一个使用网格布局管理器的窗体");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GridLayoutPosition();
    }
}
