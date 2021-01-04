package IO_Test;

import java.io.*;

/*
 * @author Hive
 * Description:FileInputStream & FileOutputStream Test
 * Date: 2021/1/4 21:15
 */
public class FileIOStreamTest {
    public static void main(String[] args) {
        File file=new File("src/booktext/FileIOStream_Test.txt");
        try{
            FileOutputStream out=new FileOutputStream(file);
            byte[] sentence=("They said that when the rider burns you,\n" +
                    "he burns your soul.").getBytes();
            out.write(sentence);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream in=new FileInputStream(file);
            byte[] read_content=new byte[1024];
            int len=in.read(read_content);
            System.out.println("Contents:\n"+new String(read_content,0,len));
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
