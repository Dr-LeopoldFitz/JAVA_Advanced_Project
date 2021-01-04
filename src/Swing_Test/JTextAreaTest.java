package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:
 * Date: 2021/1/4 17:44
 */

public class JTextAreaTest extends JFrame{
    public JTextAreaTest(){
        setSize(200,100);
        setTitle("自动换行的文本域");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container cp=getContentPane();

        // 提供默认文本以及文本域的长与宽
        String sample="I know what it's like to lose.To feel so desperately that you're"+
                "right,yet to fail nonetheless.";
        JTextArea jt=new JTextArea(sample,6,6);
        jt.setLineWrap(true);//可以自动换行
        cp.add(jt);
        setVisible(true);
    }
    public static void main(String[] args) {
        new JTextAreaTest();
    }
}