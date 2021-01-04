package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:JList Test
 * Date: 2021/1/4 16:25
 */
public class JListTest extends JFrame{
    public JListTest(){
        Container con=getContentPane();
        con.setLayout(null);

        //JScrollPane 中的列表框有滚动效果
        JList<String> jls=new JList<>(new MyListModel());
        JScrollPane jsp=new JScrollPane(jls);
        jsp.setBounds(10,10,100,70);
        con.add(jsp);

        //JPanel 中的列表框无滚动效果
        JList<String> jls2=new JList<>(new MyListModel());
        JPanel jp = new JPanel();
		jp.add(jls2);
		jp.setBounds(200, 10, 100, 200);
		con.add(jp);

		/*
		还可以使用DefaultListModel类创建列表框，
		该类扩展了AbstractListModel类，
		所以也可以通过DefaultListModel对象向上转型为ListModel接口初始化列表框，
		同时DefaultListModel类提供addElement()方法实现将内容添加至列表框中
		*/

        // 使用DefaultListModel类创建列表框
        final String[] flavors={"List1","List2","List3"};
        final DefaultListModel<String> dlm=new DefaultListModel<>();
        final JList<String> lst=new JList<>(dlm);
        for(int i=0;i<3;i++){
            dlm.addElement(flavors[i]);
        }
        jp.add(lst);
        con.add(jp);

        setTitle("在这个窗体中使用了列表框");
        setSize(350, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JListTest();
    }
}

class MyListModel extends AbstractListModel<String>{
    private String[] contents={ "列表1", "列表2", "列表3", "列表4", "列表5", "列表6" };

    public int getSize() {
        return contents.length;
    }

    public String getElementAt(int index) {
        if(index<contents.length)
            return contents[index++];
        else
            return null;
    }
}