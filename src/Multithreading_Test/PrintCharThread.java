package Multithreading_Test;

/**
 * @author Hive
 * Description:创建两个独立的线程，一个线程打印20次A，另一个线程打印20次B
 * Date: 2021/9/20 19:09
 */

public class PrintCharThread {
    public static void main(String[] args){
        printThreadA t1=new printThreadA();
        printThreadB t2=new printThreadB();
        t1.start();
        t2.start();
    }

}
class printThreadA extends Thread{
    int n=20;
    public void run(){
        while(n>0){
            System.out.print("A");
            n--;
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class printThreadB extends Thread{
    int n=20;
    public void run(){
        while(n>0){
            System.out.print("B");
            n--;
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}