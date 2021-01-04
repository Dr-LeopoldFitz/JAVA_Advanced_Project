package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:Detailed GridLayoutPosition Test
 * Date: 2021/1/3 17:29
 */

public class DetailedGridLayout extends JFrame {

    public static void main(String[] args) {
        DetailedGridLayout frame = new DetailedGridLayout();
        frame.setVisible(true);
    }

    public DetailedGridLayout() {
        super();
        setTitle("使用网格组布局管理器");
        getContentPane().setLayout(new GridBagLayout());
        setBounds(100, 100, 500, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton button = new JButton("A");
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;// 起始点为第1行
        gbc.gridx = 0;// 起始点为第1列
        gbc.weightx = 10;// 第一列的分布方式为10%
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(button, gbc);

        final JButton button_1 = new JButton("B");
        final GridBagConstraints gbc_1 = new GridBagConstraints();
        gbc_1.gridy = 0;
        gbc_1.gridx = 1;
        // 设置组件左侧的最小距离
        gbc_1.insets = new Insets(0, 5, 0, 0);
        gbc_1.weightx = 20;// 第一列的分布方式为20%
        gbc_1.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(button_1, gbc_1);

        final JButton button_2 = new JButton("C");
        final GridBagConstraints gbc_2 = new GridBagConstraints();
        gbc_2.gridy = 0;// 起始点为第1行
        gbc_2.gridx = 2;// 起始点为第3列
        gbc_2.gridheight = 2;// 组件占用两行
        gbc_2.insets = new Insets(0, 5, 0, 0);
        gbc_2.weightx = 30;// 第一列的分布方式为30%
        // 同时调整组件的宽度和高度
        gbc_2.fill = GridBagConstraints.BOTH;
        getContentPane().add(button_2, gbc_2);

        final JButton button_3 = new JButton("D");
        final GridBagConstraints gbc_3 = new GridBagConstraints();
        gbc_3.gridy = 0;
        gbc_3.gridx = 3;
        gbc_3.gridheight = 4;
        // 设置组件左侧和右侧的最小距离
        gbc_3.insets = new Insets(0, 5, 0, 5);
        gbc_3.weightx = 40;// 第一列的分布方式为40%
        gbc_3.fill = GridBagConstraints.BOTH;
        getContentPane().add(button_3, gbc_3);

        final JButton button_4 = new JButton("E");
        final GridBagConstraints gbc_4 = new GridBagConstraints();
        gbc_4.gridy = 1;
        gbc_4.gridx = 0;
        gbc_4.gridwidth = 2;// 组件占用两列
        // 设置组件上方的最小距离
        gbc_4.insets = new Insets(5, 0, 0, 0);
        // 只调整组件的宽度
        gbc_4.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(button_4, gbc_4);

        final JButton button_5 = new JButton("F");
        final GridBagConstraints gbc_5 = new GridBagConstraints();
        gbc_5.gridy = 2;// 起始点为第3行
        gbc_5.gridx = 0;// 起始点为第1列
        gbc_5.insets = new Insets(5, 0, 0, 0);
        gbc_5.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(button_5, gbc_5);

        final JButton button_6 = new JButton("G");
        final GridBagConstraints gbc_6 = new GridBagConstraints();
        gbc_6.gridy = 2;
        gbc_6.gridx = 1;
        gbc_6.gridwidth = 2;// 组件占用两列
        gbc_6.gridheight = 2;// 组件占用两行
        gbc_6.insets = new Insets(5, 5, 0, 0);
        gbc_6.fill = GridBagConstraints.BOTH;// 调整组件的高度宽度
//		gbc_6.fill = GridBagConstraints.VERTICAL;// 只调整组件的高度
//		gbc_6.ipadx = 30;// 增加组件的首选宽度
//		gbc_6.anchor = GridBagConstraints.EAST;// 显示在东方
        getContentPane().add(button_6, gbc_6);

        final JButton button_7 = new JButton("H");
        final GridBagConstraints gbc_7 = new GridBagConstraints();
        gbc_7.gridy = 3;
        gbc_7.gridx = 0;
        gbc_7.insets = new Insets(5, 0, 0, 0);
        gbc_7.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(button_7, gbc_7);
    }

}