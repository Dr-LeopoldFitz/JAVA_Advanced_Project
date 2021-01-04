package Swing_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * @author Hive
 * Description:JCheckBox Test
 * Date: 2021/1/4 14:16
 */

public class JCheckBoxTest extends JFrame {

    private JPanel panel1 = new JPanel(); //选中信息提示框
    private JPanel panel2 = new JPanel(); //复选按钮组
    private JTextArea jt = new JTextArea(4, 10);
    private JCheckBox jc1 = new JCheckBox("1");
    private JCheckBox jc2 = new JCheckBox("2");
    private JCheckBox jc3 = new JCheckBox("3");

    public JCheckBoxTest() {
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        /* FlowLayout、BorderLayout、GridLayout、CardLayout、GridBagLayout */
        con.add(panel1, BorderLayout.NORTH);
        final JScrollPane scrollPane = new JScrollPane(jt);
        panel1.add(scrollPane);
        con.add(panel2, BorderLayout.SOUTH);

        panel2.add(jc1);
        jc1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jc1.isSelected())
                    jt.append("复选框1被选中\n");
            }
        });

        panel2.add(jc2);
        jc2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jc2.isSelected())
                    jt.append("复选框2被选中\n");
            }
        });

        panel2.add(jc3);
        jc3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jc3.isSelected())
                    jt.append("复选框3被选中\n");
            }
        });

        setSize(400, 160);
        setVisible(true);
        setTitle("复选框的使用");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JCheckBoxTest();
    }

}