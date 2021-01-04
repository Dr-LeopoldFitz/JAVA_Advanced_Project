package IO_Test;

import java.io.*;

/*
 * @author Hive
 * Description:DataInputStream & DataOutputStream Test
 * Date: 2021/1/4 23:04
 */

public class DataIOStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fs = new FileOutputStream("src/booktext/DataIOStream_Test.txt");
            DataOutputStream ds = new DataOutputStream(fs);
            ds.writeUTF("使用writeUTF()方法写入数据;");
            //ds.writeChars("使用writeChars()方法写入数据;");
            //ds.writeBytes("使用writeBytes()方法写入数据.");
            ds.close(); // 将流关闭

            FileInputStream fis = new FileInputStream("src/booktext/DataIOStream_Test.txt");
            DataInputStream dis = new DataInputStream(fis);
            System.out.print(dis.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
