package Multithreading_Test;

/**
 * @author Hive
 * Description:ThreadSafeTest类实现Runnable接口，模拟火车站售票系统功能
 * Date: 2021/9/9 19:20
 */
public class ThreadSafeTest implements Runnable {
    int num = 10;

    public void run() {
        while (true) {
            synchronized ("") {
                if (num > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("tickets" + --num);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest t = new ThreadSafeTest();
        Thread tA = new Thread(t);
        Thread tB = new Thread(t);
        Thread tC = new Thread(t);
        Thread tD = new Thread(t);
        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }
}
