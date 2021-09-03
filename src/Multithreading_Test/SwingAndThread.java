package Multithreading_Test;

/**
 * @author Hive
 * Description:实现图标移动的功能
 * Date: 2021/9/3 11:04
 */
import java.awt.*;
import java.net.*;

import javax.swing.*;

public class SwingAndThread extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel jl = new JLabel(); // 声明JLabel对象
    private static Thread t; // 声明线程对象
    private int count = 0; // 声明计数变量
    private Container con = getContentPane(); // 声明容器

    public SwingAndThread() {
        setBounds(300, 200, 250, 100); // 绝对定位窗体大小与位置
        con.setLayout(null); // 使窗体不使用任何布局管理器
        URL url = SwingAndThread.class.getResource("SwingThread.gif"); // 获取图片的URL
        //URL资源必须在本包或者本类class同目录
        /*getResource接受一个字符串参数，如果以”/”开头，就在classpath根目录下找
        （不会递归查找子目录），如果不以”/”开头，就在调用getResource的字节码(源代码)对象
        所在目录下找（同样不会递归查找子目录）*/
        Icon icon = new ImageIcon(url); // 实例化一个Icon
        jl.setIcon(icon); // 将图标放置在标签中
        // 设置图片在标签的最左方
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10, 10, 200, 50); // 设置标签的位置与大小
        jl.setOpaque(true);
        con.add(jl); // 将标签添加到容器中
        t = new Thread(new Runnable() { // 定义匿名内部类，该类实现Runnable接口
            public void run() { // 重写run()方法
                while (count <= 200) { // 设置循环条件
                    // 将标签的横坐标用变量表示
                    jl.setBounds(count, 10, 200, 50);
                    try {
                        Thread.sleep(1000); // 使线程休眠1000毫秒
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count += 4; // 使横坐标每次增加4
                    if (count == 200) {
                        // 当图标到达标签的最右边，使其回到标签最左边
                        count = 10;
                    }
                }
            }
        });
        t.start(); // 启动线程
        setVisible(true); // 使窗体可视
        // 设置窗体的关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingAndThread(); // 实例化一个SwingAndThread对象
    }
}
