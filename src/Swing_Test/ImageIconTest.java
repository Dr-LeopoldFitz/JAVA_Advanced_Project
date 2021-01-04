package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:ImageIcon Test
 * Date: 2021/1/3 12:01
 */

public class ImageIconTest extends JFrame {
    public ImageIconTest(){
        Container con=getContentPane();
        JLabel jl=new JLabel("这是一个JFrame窗体",JLabel.CENTER);
        Icon icon=new ImageIcon("src/bookimage/imageButton.jpg");
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setOpaque(true);

        con.add(jl);
        setSize(250,100);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageIconTest();
    }
}
