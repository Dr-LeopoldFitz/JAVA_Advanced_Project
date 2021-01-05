package IO_Test;

import java.io.*;
import java.util.zip.*;

/*
 * @author Hive
 * Description:ZipOutputStream Test - FileCompressing
 * Description:Compress File1,File2 at Folder 'FilesToCompress' to File_Compressed.zip
 * Date: 2021/1/4 23:22
 */

public class ZipOutputStreamTest {
    private static void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) { // 测试此抽象路径名表示的文件是否是一个目录
            File[] fl = f.listFiles(); // 获取文件路径数组
            //fl[0]=src\bookinputfile\FilesToCompress\File1.txt
            //fl[1]=src\bookinputfile\FilesToCompress\File2.txt
            //fl[2]=src\bookinputfile\FilesToCompress\testfolder
            for (File file : fl) {
                if(file.isDirectory()){
                    zip(out, file, base +File.separator+ file.getName());//递归
                }
                else{
                    zip(out, file, base);
                }
            }
        }
        else {
            ZipEntry next=new ZipEntry(base+File.separator+f.getName());
            /* System.out.println(next);
             * FilesToCompress\File1.txt
             * FilesToCompress\File2.txt
             * FilesToCompress\testfolder\File3.txt
             */
            out.putNextEntry(next); // 创建新的进入点
            FileInputStream in = new FileInputStream(f);
            int b;
            while ((b = in.read()) != -1) { // 如果没有到达流的尾部
                out.write(b); // 将字节写入当前ZIP条目
            }
            in.close(); // 关闭流
        }
    }

    public static void main(String[] args) throws Exception{
        String entry="src/bookinputfile/FilesToCompress";
        File file=new File(entry);
        String out_path="src/bookoutputfile/File_Compressed.zip";
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(out_path));
        String base = file.getName();//base即为压缩文件中的第一层目录
        //base: FilesToCompress
        zip(out, file, base);
        System.out.println("原始文件路径:"+entry);
        System.out.println("'FilesToCompress' 正在压缩中..."); // 输出信息
        out.closeEntry();
        out.close(); // 将流关闭
        System.out.println("压缩完成!");
        System.out.println("压缩文件输出路径:"+out_path);
    }
}