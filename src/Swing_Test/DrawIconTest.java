package Swing_Test;

import javax.swing.*;
import java.awt.*;
/*
 * @author Hive
 * Description:DrawIcon Test
 * Date: 2021/1/3 11:16
 */

public class DrawIconTest implements Icon{
    private int width;
    private int height;

    public int getIconHeight(){
        return this.height;
    }
    public int getIconWidth(){
        return this.width;
    }
    public DrawIconTest(int width, int height){
        this.width=width;
        this.height=height;
    }
    public void paintIcon(Component arg0,Graphics arg1,int x,int y){
        arg1.setColor(Color.RED);
        arg1.fillOval(x, y, width, height);
    }

    public static void main(String[] args){
        DrawIconTest icon=new DrawIconTest(30, 30);
        JLabel jl=new JLabel("TEST",icon,SwingConstants.CENTER);
        JFrame jf=new JFrame("DrawIcon测试");
        Container con=jf.getContentPane();
        con.add(jl);
        jf.setSize(400,200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
