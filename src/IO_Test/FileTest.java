package IO_Test;

import java.io.*;

/*
 * @author Hive
 * Description:Simple File Test
 * Date: 2021/1/4 21:08
 */
public class FileTest {
    public static void main(String[] args) {
        File f=new File("src/bookimage/imageButton.jpg");
        if(f.exists()){
            String name=f.getName();
            long length=f.length();
            boolean hidden=f.isHidden();
            System.out.println("文件名称："+name);
            System.out.println("文件长度："+length);
            System.out.println("文件是否隐藏："+hidden);
        }
        else{
            System.out.println("文件不存在!");
        }
    }
}
