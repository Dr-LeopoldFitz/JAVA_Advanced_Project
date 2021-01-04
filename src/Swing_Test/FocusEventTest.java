package Swing_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/*
 * @author Hive
 * Description:FocusEvent Test,With a special Focus-Detection method By Hive(col 24-59)
 * Date: 2021/1/4 18:15
 */
public class FocusEventTest extends JFrame{
    public FocusEventTest(){
        setSize(250,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container con=getContentPane();
        con.setLayout(new FlowLayout());

        final JLabel label=new JLabel("Selected Field");
        con.add(label);
        JTextField jtf1=new JTextField("单击其他文本框",10);
        JTextField jtf2=new JTextField("单击此处",10);
        jtf1.addFocusListener(new FocusListener() {
            boolean i=true; //i检测上一次焦点是否落在第一个文本框
            int time=0; //time用来特判第一次点击是否仍为第一个文本框
            boolean j=false;//j检测上一次焦点是否落在第二个文本框。i，j在同一时刻必一正一负
            /*
            必须要用ij来存储上一步的动作，因为点击弹出的窗口时也算失去焦点，
            如果只是简单地在focusGained函数内输出获得焦点，在focusLost内输出失去焦点
            则抛开第一次特判不说，在点击失去焦点的弹窗提示时仍为失去焦点的状态，形成”失去焦点“的死循环
             */
            @Override
            public void focusGained(FocusEvent e) {
                if(i&&time==0){ //初始化焦点已在第一个文本框，第一次的点击若是点击第一个文本框不应出现重获焦点提示
                    time=1;
                }
                else if(!i&&j){ //不是第一次点击，且上一次点击的是第二个文本框或失去焦点的弹窗，焦点回到第一个文本框
                    JOptionPane.showMessageDialog(null, "文本框重获焦点");
                    i=true;
                    j=false;
                }
                else{ //不是第一次点击，但上一次点击的是第一个文本框，焦点仍在第一个文本框，所以无需任何提示
                    i=true;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(i&&!j){ //上一次点击的是第一个文本框以及其引发的重获焦点的弹出提示窗口，本次点击
                    JOptionPane.showMessageDialog(null, "文本框已失去焦点");
                    j=true;
                    i=false;
                }
                else{ //上一次点击的是第二个文本框或其引发的失去焦点的弹窗，焦点仍未回到第一个文本框
                    j=true;
                }
            }
        });

        con.add(jtf1);
        con.add(jtf2);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FocusEventTest();
    }
}
