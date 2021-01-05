package IO_Test;

import java.io.*;
import java.util.Scanner;

/*
 * @author Hive
 * Description:实现当用户输入姓名和密码时，将每一个姓名和密码加在文件中，如果输入done，就结束程序
 * Date: 2021/1/5 16:13
 */

public class Test_UserAccount {
    public static void main(String[] args) {
        FileWriter fw;

        try {
            fw = new FileWriter("src/bookoutputfile/UserAccounts.txt");
            while (true) {
                System.err.println("请输入一个名字：");
                Scanner input=new Scanner(System.in);
                String name=input.next();
                if ("done".equalsIgnoreCase(name)) {
                    System.out.println("录入完毕");
                    break;
                }

                System.err.println("请输入电话号：");
                String number=input.next();
                fw.write(name);
                fw.write(',');
                fw.write(number);
                fw.write('\n');
                System.out.println("信息已经写入文件");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}