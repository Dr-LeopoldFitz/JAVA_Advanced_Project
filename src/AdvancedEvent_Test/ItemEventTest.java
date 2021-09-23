package AdvancedEvent_Test;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @author Hive
 * Description:选项事件
 * Date: 2021/9/23 12:45
 */

public class ItemEventTest extends JFrame {

    public static void main(String[] args) {
        ItemEventTest frame = new ItemEventTest();
        frame.setVisible(true);
    }

    public ItemEventTest() {
        super();
        getContentPane().setLayout(new FlowLayout());
        setTitle("选项事件示例");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> comboBox = new JComboBox<>();// 创建一个下拉菜单
        for (int i = 1; i < 6; i++) {// 通过循环添加选项
            comboBox.addItem("选项" + i);
        }
        comboBox.addItemListener(new ItemListener() {// 添加选项事件监听器
            public void itemStateChanged(ItemEvent e) {
                int stateChange = e.getStateChange();// 获得事件类型
                String item = e.getItem().toString();// 获得触发此次事件的选项
                if (stateChange == ItemEvent.SELECTED) {// 查看是否由选中选项触发
                    System.out.println("此次事件由      选中  选项“" + item + "”触发！");
                    // 查看是否由取消选中选项触发
                } else if (stateChange == ItemEvent.DESELECTED) {
                    System.out.println("此次事件由  取消选中  选项“" + item + "”触发！");
                } else {// 由其他原因触发
                    System.out.println("此次事件由其他原因触发！");
                }
            }
        });
        getContentPane().add(comboBox);
    }

}
