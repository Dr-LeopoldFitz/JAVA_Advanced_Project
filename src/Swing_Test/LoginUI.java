package Swing_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @author Hive
 * Description:Simple Login UI
 * Login ID:alveus
 * Password:alveusmeanshive
 * Date: 2021/1/4 20:01
 */

public class LoginUI extends JFrame {

    public LoginUI() {
        setTitle("Login to Framework");
        setBounds(500, 200, 400, 150);
        Container cp = getContentPane();
        cp.setLayout(null);

        JLabel jl = new JLabel("Login ID：");
        jl.setBounds(30, 10, 200, 18);
        final JTextField name = new JTextField();
        name.setBounds(90, 10, 150, 20);
        JLabel jl2 = new JLabel("Password：");
        jl2.setBounds(20, 50, 200, 18);
        final JPasswordField password = new JPasswordField();
        password.setBounds(90, 50, 150, 20);
        //password.setEchoChar('#'); // 设置回显字符

        cp.add(jl);
        cp.add(name);
        cp.add(jl2);
        cp.add(password);

        JButton jb = new JButton("Login");
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (name.getText().trim().length() == 0
                        || new String(password.getPassword()).trim().length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "The user name and password cannot be empty! ");
                    return;
                }
                if (name.getText().trim().equals("alveus")
                        && new String(password.getPassword()).trim()
                        .equals("alveusmeanshive")) {
                    JOptionPane.showMessageDialog(null,
                            "Login successfully! ");
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Wrong username or password! ");
                }
            }
        });
        jb.setBounds(80, 80, 80, 18);
        cp.add(jb);

        final JButton button = new JButton();
        button.setText("Reset");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                password.setText("");
            }
        });
        button.setBounds(170, 80, 80, 18);
        getContentPane().add(button);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }

}