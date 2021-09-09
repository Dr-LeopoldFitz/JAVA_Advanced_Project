package Multithreading_Test;

/**
 * @author Hive
 * Description:每隔1000毫秒打印一句话
 * Date: 2021/9/9 19:30
 */
public class PrintThread extends Thread {
    int index=0;
    String[] str={"可爱可恨","可有遗憾","是你是他","又与谁相关","淙淙潺潺","簌簌款款"};
    public void run() {
        while (true) {
            System.out.println(str[index++%6]);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PrintThread().start();
    }
}

