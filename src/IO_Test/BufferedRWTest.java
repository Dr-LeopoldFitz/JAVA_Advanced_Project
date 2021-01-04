package IO_Test;

import java.io.*;

/*
 * @author Hive
 * Description:BufferedReader & BufferedWriter Test
 * Date: 2021/1/4 22:38
 */

public class BufferedRWTest {
    public static void main(String[] args) {
        String[] content = { "淙淙潺潺", "簌簌款款", "娓娓诉说不惊波澜" };
        File file = new File("src/booktext/BufferedRW_Test.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bfw = new BufferedWriter(fw);
            for (String s : content) {
                bfw.write(s); // 将字符串数组中元素写入到磁盘文件中
                bfw.newLine(); // 另开一行，将数组中的单个元素以单行的形式写入文件
            }
            bfw.close(); // 将BufferedWriter流关闭
            fw.close(); // 将FileWriter流关闭
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            String s = null;
            int i = 0;
            while ((s = bfr.readLine()) != null) {
                i++;
                System.out.println("第" + i + "行: " + s); // 输出文件数据
            }
            bfr.close(); // 将FileReader流关闭
            fr.close(); // 将FileReader流关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}