package Swing_Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

/**
 * @author Hive
 * Description:图形界面日历
 * Date: 2021/9/20 15:35
 */

public class SwingCalendar {
    JFrame jf=new JFrame("日历");
    JPanel daypanel = new JPanel();
    JPanel controlbutton = new JPanel();
    JPanel dateinfo = new JPanel();
    JLabel[] labelDay = new JLabel[42]; //最多6行*7天=42
    JButton[] titleName = new JButton[7];
    JButton next=new JButton("下月");
    JButton previous =new JButton("上月");
    String[] name ={"日","一","二","三","四","五","六"};
    Calendar ca=Calendar.getInstance();
    int year=ca.get(Calendar.YEAR);
    int month=ca.get(Calendar.MONTH)+1;
    JLabel detail =new JLabel();
    public SwingCalendar(){
        jf.setVisible(true);
        jf.setBounds(300,300,1100,800);
        jf.setLayout(new BorderLayout());
        daypanel.setLayout(new GridLayout(7,7));
        jf.add(daypanel,BorderLayout.CENTER);
        jf.add(controlbutton,BorderLayout.NORTH);
        jf.add(dateinfo,BorderLayout.SOUTH);
        controlbutton.add(previous);
        controlbutton.add(next);
        detail.setText(year+"年"+month+"月");
        dateinfo.add(detail);
        detail.setFont(new Font("宋体", Font.BOLD, 30));
        next.setFont(new Font("宋体", Font.BOLD, 30));
        previous.setFont(new Font("宋体", Font.BOLD, 30));

        for(int i=0;i<7;i++){
            titleName[i]=new JButton(name[i]);
            daypanel.add(titleName[i]);
            titleName[i].setFont(new Font("宋体", Font.BOLD, 20));
        }
        for(int i=0;i<42;i++){
            labelDay[i]=new JLabel("",JLabel.CENTER);
            daypanel.add(labelDay[i]);
            labelDay[i].setFont(new Font("宋体", Font.BOLD, 20));
        }

        String[] a =getCalendar(year,month);
        for(int i=0;i<42;i++){
            labelDay[i].setText(a[i]);
        }
        previous.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== previous){
                    month=month-1;
                    if(month<1)
                    {month=12;year--;}
                    String[] day =getCalendar(year,month);
                    for(int i=0;i<42;i++){
                        labelDay[i].setText(day[i]);
                    }
                }
                detail.setText(year+"年"+month+"月");
            }

        });
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==next){
                    month=month+1;
                    if(month>12)
                    {month=1;year++;}
                    String[] day =getCalendar(year,month);
                    for(int i=0;i<42;i++){
                        labelDay[i].setText(day[i]);
                    }
                }
                detail.setText(year+"年"+month+"月");
            }

        });
    }
    public String[] getCalendar(int year,int month){
        String[] a =new String[42];
        Calendar calen=Calendar.getInstance();
        calen.set(year,month-1,1);
        int weekday=calen.get(Calendar.DAY_OF_WEEK)-1;
        int day=0;
        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            day=31;
        if(month==4||month==6||month==9||month==11)
            day=30;
        if(month==2){
            if(((year%4==0)&&(year%100!=0))||(year%400==0))
                day=29;
            else
                day=28;
        }
        for(int i=0;i<weekday;i++){
            a[i]=" ";
        }
        for(int i=weekday,n=1;i<weekday+day;i++){
            a[i]=String.valueOf(n);
            n++;
        }
        for(int i=weekday+day;i<a.length;i++){
            a[i]=" ";
        }
        return a;
    }

    public static void main(String[] args) {
        new SwingCalendar();
    }

}
