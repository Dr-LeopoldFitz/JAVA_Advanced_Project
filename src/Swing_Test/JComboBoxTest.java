package Swing_Test;

import javax.swing.*;
import java.awt.*;

/*
 * @author Hive
 * Description:JComboBox & JComboBoxModel Test
 * Date: 2021/1/4 15:08
 */

public class JComboBoxTest extends JFrame{
    JComboBox<String> jcbs =new JComboBox<>(new MyComboBox());
    JLabel jl=new JLabel("请选择证件：");

    public JComboBoxTest(){
        setSize(new Dimension(300,180));
        //同setSize(300,180);
        setTitle("JComboBox Test");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container con=getContentPane();
        con.setLayout(new FlowLayout());
        con.add(jl);
        con.add(jcbs);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JComboBoxTest();
    }
}

class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String>{
    String selected=null;
    String[] test={"身份证","军人证","学生证","工作证"};

    //实现AbstractListModel中abstract方法 getSize 和 getElementAt
    public int getSize(){
        return test.length;
    }
    public String getElementAt(int index){
        return test[index];
    }

    //实现ComboBoxModel中abstract方法 setSelectedItem(Object) 和 getSelectedItem()
    public void setSelectedItem(Object item){
        selected=(String)item;
    }
    public Object getSelectedItem(){
        return selected;
    }

    public int getIndex(){
        for(int i=0;i< test.length;i++){
            if(test[i].equals(getSelectedItem())){
                return i;
            }
        }
        return 0;
    }
}