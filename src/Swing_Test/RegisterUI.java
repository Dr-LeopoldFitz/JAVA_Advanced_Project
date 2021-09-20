package Swing_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

/**
 * @author Hive
 * Description:注册界面
 * Date: 2021/9/20 15:54
 */

class MyListener implements FocusListener {
    JTextField username;
    JPasswordField userpass;
    JPasswordField confirmpass;
    JTextField email;
    JLabel warnlab1;
    JLabel warnlab2;
    JLabel warnlab3;
    JLabel warnlab4;
    public void setLabel(JLabel a, JLabel b, JLabel c, JLabel d){
        warnlab1 =a;
        warnlab2 =b;
        warnlab3 =c;
        warnlab4 =d;
    }
    public void setText(JTextField a, JPasswordField b, JPasswordField c, JTextField d){
        username =a;
        userpass =b;
        confirmpass =c;
        email =d;
    }
    public void focusGained(FocusEvent arg0){
    }
    public void focusLost(FocusEvent arg0){
        if(arg0.getSource()== username){
            String str= username.getText();
            String judge="^[^\\s]{6,20}$";
            if(!str.matches(judge)){
                warnlab1.setText("用户名必须是不含空格的8-16位字符串");
            }
            else{
                warnlab1.setText("");
            }
            warnlab1.setBounds(350,110,500,30);
        }
        if(arg0.getSource()== userpass){
            String str=new String(userpass.getPassword());

            String judge="^[^\\s\\u4e00-\u9fa5]{8,20}$";
            if(!str.matches(judge)){
                warnlab2.setText("密码必须是8-20位的可含标点符号或单词字符的字符串");
            }
            else{
                warnlab2.setText("");
            }
            warnlab2.setBounds(350,210,500,30);
        }
        if(arg0.getSource()== confirmpass){
            String str=new String(userpass.getPassword());
            String str1=new String(confirmpass.getPassword());
            if(!str.equals(str1)){
                warnlab3.setText("确认密码必须与密码相同");
            }
            else{
                warnlab3.setText("");
            }
            warnlab3.setBounds(350,310,500,30);
        }
        if(arg0.getSource()== email){
            String str= email.getText();
            String judge="^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            if(!str.matches(judge)){
                warnlab4.setText("请输入合法的邮箱地址");
            }
            else{
                warnlab4.setText("");
            }
            warnlab4.setBounds(350,410,500,30);
        }
    }

}

public class RegisterUI extends JFrame {
    JTextField text1,text4;
    JPasswordField text2,text3;
    JLabel label1,label2,label3,label4;
    JButton but1,but2;
    JLabel warn1,warn2,warn3,warn4;
    MyListener listener=new MyListener();

    public RegisterUI()
    {
        super("注册");
        setBounds(100,200,800,600);
        setLayout(null);
        label1=new JLabel("用户名:");add(label1);
        label2=new JLabel("密码:");add(label2);
        label3=new JLabel("确认密码:");add(label3);
        label4=new JLabel("邮箱:");add(label4);
        but1=new JButton("提交");add(but1);
        but2=new JButton("取消");add(but2);
        text1=new JTextField(60);add(text1);
        text2=new JPasswordField(60);add(text2);
        text3=new JPasswordField(60);add(text3);
        text4=new JTextField(60);add(text4);

        label1.setBounds(250,80,60,30);
        label2.setBounds(250,180,60,30);
        label3.setBounds(250,280,60,30);
        label4.setBounds(250,380,60,30);
        but1.setBounds(300,450,60,30);
        but2.setBounds(480,450,60,30);
        text1.setBounds(350,80,150,30);
        text2.setBounds(350,180,150,30);
        text3.setBounds(350,280,150,30);
        text4.setBounds(350,380,150,30);
        warn1=new JLabel();	add(warn1);
        warn1.setForeground(Color.red);
        warn2=new JLabel(); add(warn2);
        warn2.setForeground(Color.red);
        warn3=new JLabel(); add(warn3);
        warn3.setForeground(Color.red);
        warn4=new JLabel(); add(warn4);
        warn4.setForeground(Color.red);
        setVisible(true);
        but1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                if(warn1.getText().equals("")&&warn2.getText().equals("")&&warn3.getText().equals("")&&warn4.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"登录成功");
                else{
                    JOptionPane.showMessageDialog(null, "注册失败");
                }
            }
        });
        but2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        listener.setLabel(warn1,warn2,warn3,warn4);
        listener.setText(text1, text2, text3, text4);
        text1.addFocusListener(listener);
        text2.addFocusListener(listener);
        text3.addFocusListener(listener);
        text4.addFocusListener(listener);
    }
    public static void main(String[] args) {
        new RegisterUI();
    }
}

