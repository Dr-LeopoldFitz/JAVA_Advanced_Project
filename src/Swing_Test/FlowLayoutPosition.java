package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:FlowLayout Position Test
 * Date: 2021/1/3 13:39
 */
public class FlowLayoutPosition extends JFrame{
    public FlowLayoutPosition(){
        setTitle("本窗体使用流布局管理器");
        Container con=getContentPane();
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        for(int i=0;i<30;i++){
            con.add(new JButton("Button"+i));
        }
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FlowLayoutPosition();
    }
}
