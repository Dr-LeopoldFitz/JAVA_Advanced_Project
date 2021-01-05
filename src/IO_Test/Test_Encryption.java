package IO_Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * @author Hive
 * Description:使用字符输入、输出流读取文件，将一段文字加密后存入文件，然后再读取，并将加密前与加密后的文件输出。
 * Date: 2021/1/5 15:52
 */

public class Test_Encryption {
    public static void main(String[] args) {
        char[] sentence = "岁月赠别离，可知其深意".toCharArray();
        int n = 0;
        try {
            File out = new File("src/bookoutputfile/EncryptedText.txt");
            for (int i = 0; i < sentence.length; i++) {
                sentence[i] = (char) (sentence[i] ^ 'Q');
                //sentence[i]与'Q'分别转成二进制后进行按位异或运算，运算完毕之后转成char
            }
            FileWriter fw = new FileWriter(out);
            fw.write(sentence, 0, sentence.length);
            fw.close();

            FileReader fr = new FileReader(out);
            char[] char_str = new char[128];
            System.out.println("加密后：");
            while ((n = fr.read(char_str, 0, 128)) != -1) {
                String s = new String(char_str, 0, n);
                System.out.println(s);
            }
            fr.close();

            fr = new FileReader(out);
            System.out.println("明文：");
            while ((n = fr.read(char_str, 0, 128)) != -1) {
                for (int j = 0; j < n; j++) {
                    char_str[j] = (char) (char_str[j] ^ 'Q');
                }
                String str = new String(char_str, 0, n);
                System.out.println(str);
            }

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
/*
 * 加密后：
 * 亘奻cb烫冨厃
 * 明文：
 * 今天10点出发
 */