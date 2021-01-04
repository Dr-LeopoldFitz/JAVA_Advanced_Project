package Swing_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/*
 * @author Hive
 * Description:JButton Test
 * Date: 2021/1/4 12:24
 */
public class JButtonTest extends JFrame{
    public JButtonTest(){
        URL jpg_url=JButtonTest.class.getResource("/bookimage/imageButton.jpg");
        Icon icon=new ImageIcon(jpg_url);
        setLayout(new GridLayout(3,2,5,5));
        Container con=getContentPane();
        for(int i=0;i<5;i++){
            JButton jb=new JButton("Button"+i,icon);
            con.add(jb);
            if(i%2==0){
                jb.setEnabled(false); // 设置其中一些按钮不可用
            }
        }
        JButton jb=new JButton("点击可触发");// 实例化一个没有文字与图片的按钮
        jb.setIcon(icon);
        jb.setToolTipText("图片按钮");// 设置按钮提示文字
        jb.setBorderPainted(false); // 设置按钮边界不显示
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "弹出对话框");
                //同 JOptionPane.showMessageDialog(JButtonTest.this, "弹出对话框");
                /*第一个参数是parentComponent,如果null,使用默认值Frame*/

                /*弹窗写法2
                JDialog jd=new JDialog(JButtonTest.this,"JDialog消息",true);
                jd.add(new JLabel("这是一个对话框"));
                jd.setBounds(200,120,150,100);
                jd.setVisible(true);
                //setVisible要放在所有参数设置完成之后，否则在此之后的参数(有!可!能!)设置无效
                */
            }
        });
        con.add(jb);

        setTitle("JButton Test");
        setSize(450,150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonTest();
    }
}
