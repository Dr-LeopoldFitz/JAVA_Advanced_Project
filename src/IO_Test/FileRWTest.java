package IO_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * @author Hive
 * Description:创建Swing窗体，单击窗体中的“Write File”按钮实现将文本框中的数据写入到磁盘文件中，
 * Description:单击“Read File”按钮，系统将磁盘文件中的信息显示在文本框中。
 * Date: 2021/1/4 21:32
 */

public class FileRWTest extends JFrame {

    private JScrollPane scrollPane;
    private JPanel jContentPane = null; // 创建面板对象
    private JTextArea jTextArea = null; // 创建文本域对象
    private JPanel controlPanel = null; // 创建面板对象
    private JButton openButton = null;  // 创建按钮对象
    private JButton closeButton = null; // 创建按钮对象

    private JTextArea getJTextArea() {
        if (jTextArea == null) {
            jTextArea = new JTextArea();
        }
        return jTextArea;
    }

    private JPanel getControlPanel() {
        if (controlPanel == null) {
            controlPanel = new JPanel();
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setVgap(1);
            controlPanel.setLayout(flowLayout);
            controlPanel.add(getOpenButton(), null);
            controlPanel.add(getCloseButton(), null);
        }
        return controlPanel;
    }

    private JButton getCloseButton() {
        if (openButton == null) {
            openButton = new JButton();
            openButton.setText("Write File");
            openButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent args0) {
                    File file = new File("src/booktext/FileRW_Test.txt");
                    try {
                        FileWriter out = new FileWriter(file);// 创建FileWriter对象
                        String s = jTextArea.getText();// 获取文本域中文本
                        out.write(s); // 将信息写入磁盘文件
                        out.close(); // 将流关闭
                        JOptionPane.showMessageDialog(null, "写入文件'FileRW_Test.txt'成功!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return openButton;
    }

    private JButton getOpenButton() {
        if (closeButton == null) {
            closeButton = new JButton();
            closeButton.setText("Read File");
            closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent args0) {
                    File file = new File("src/booktext/FileRW_Test.txt");
                    try {
                        FileReader in = new FileReader(file);// 创建FileReader对象
                        char[] read_content = new char[1024]; // 创建char型数组
                        int len = in.read(read_content); // 将字节读入数组
                        jTextArea.setText(new String(read_content, 0, len));// 设置文本域的显示信息
                        in.close(); // 关闭流
                        JOptionPane.showMessageDialog(null, "读取文件'FileRW_Test.txt'成功!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return closeButton;
    }

    private void initialize() {
        this.setSize(300, 200);
        this.setContentPane(getJPanel());
        this.setTitle("File R.W. Test");
    }

    private JPanel getJPanel() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getScrollPane(), BorderLayout.CENTER);
            jContentPane.add(getControlPanel(), BorderLayout.SOUTH);
        }
        return jContentPane;
    }

    public FileRWTest() {
        super();
        initialize();
    }
    protected JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setViewportView(getJTextArea());
            /*
             * public void setViewportView(Component view)
             * 创建一个视口并设置其视图。不直接为 JScrollPane构造方法提供视图的应用程序
             * 应使用此方法指定将显示在滚动窗格中的滚动组件子级。
             */
        }
        return scrollPane;
    }

    public static void main(String[] args) {
        FileRWTest rwtest = new FileRWTest();
        rwtest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rwtest.setVisible(true);
    }

}