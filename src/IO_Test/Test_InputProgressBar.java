package IO_Test;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

/*
 * @author Hive
 * Description:实现读取文件时出现一个表示读取进度的进度条。
 * Description:使用javax.swing包的输入流类ProgressMonitorInputStream
 * Date: 2021/1/5 14:48
 */

public class Test_InputProgressBar {
    public static void main(String[] temp) {
        byte[] b = new byte[1];
        /*
         *UTF中 一个中文文字占3字节,每次读取3字节
         *若文件以汉字，则 byte[3]，byte[MAX](如 MAX=1024)均可，若开头非中文，则若每次读取3字节，
         *读取到第一个中文时可能夹带前面语言的一些字节导致乱码，此时只能byte[MAX]
         *但是每次读取3字节可能导致最后输出多余字符的问题，不推荐
         */
        try{
            String file_path="src/bookinputfile/ein_Lyrics.txt";
            FileInputStream fis = new FileInputStream(file_path);
            ProgressMonitorInputStream in =
                    new ProgressMonitorInputStream(null,"读取文件中...",fis);
            while(in.read(b)!=-1){
                String s = new String(b);
                System.out.print(s);
                Thread.sleep(10);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}