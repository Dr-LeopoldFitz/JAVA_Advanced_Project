package IO_Test;

import java.io.*;
import java.util.zip.*;

/*
 * @author Hive
 * Description:ZipInputStream Test - File Decompressing
 * Description:Decompress compressed_file.zip to Decompressed_File
 * Date: 2021/1/5 12:43
 */

public class ZipInputStreamTest {

    public static void Decompress(File out_file,File zip_file,String parent){
        System.out.println("文件'"+zip_file.getName()+"'解压中...");
        try{
            ZipEntry entry;
            ZipInputStream zin = new ZipInputStream(new FileInputStream(zip_file));
            while((entry= zin.getNextEntry())!=null){
                /* System.out.println(entry);
                 *
                 * compress_file1.txt
                 * compress_file2.txt
                 * compressed_folder/
                 * compressed_folder/folder2/
                 * compressed_folder/folder2/hive_test.txt
                 * compressed_folder/Lyrics.txt
                 *
                 * 可知无论是文件还是文件夹都是一个entry
                 */
                if(!entry.isDirectory())
                    out_file=new File(parent,entry.getName());
                if(entry.isDirectory()){
                    continue; //如果entry是文件夹，跳过此entry，检测下一个entry
                }
                if(!out_file.exists()){
                    /*
                     * public boolean exists()
                     * Tests whether the file or directory denoted by this
                     * abstract pathname exists.
                     *
                     * 注意：检测文件 或 文件夹是否存在，无论文件还是文件夹都可以检测
                     */

                    //getParent()获取为除去该文件的前几级路径 如src/file/a.txt的parent为src/file
                    (new File(out_file.getParent())).mkdirs();
                    /*
                     * public boolean mkdirs()
                     * Creates the directory named by this abstract pathname,
                     * including any necessary but nonexistent parent directories.
                     *
                     * 注意：不仅会建立上一级文件夹，如果有必要会将之前的几级文件夹都创建 如 folder2
                     */
                }

                //确定筛选出的为单文件 且 其前几级文件夹已存在，向磁盘写入文件
                FileOutputStream fos=new FileOutputStream(out_file);
                int b;
                while((b = zin.read())!= -1) {
                    fos.write(b);
                }
                fos.close();
            }
            zin.close(); // 关闭流
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String zip_path="src/bookinputfile/compressed_file.zip";
        String out_path="src/bookoutputfile/Decompressed_File";

        File zip_file=new File(zip_path);
        File out_file=new File(out_path);
        String parent="src/bookoutputfile/Decompressed_File";

        System.out.println("原始压缩文件路径:"+zip_path);
        Decompress(out_file, zip_file, parent);
        System.out.println("解压成功!");
        System.out.println("输出路径:"+out_path);

    }
}
