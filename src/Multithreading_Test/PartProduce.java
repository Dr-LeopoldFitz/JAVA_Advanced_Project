package Multithreading_Test;

/**
 * @author Hive
 * Description:有一批零件的生产任务，总量是800个，生产一个零件耗时 10ms
 * 有4个车间共同完成这一批任务，分别统计每个车间各自生产了多少个零件并输出
 * Date: 2021/9/20 20:13
 */

public class PartProduce {
    public static void main(String[] args){
        Produce p=new Produce();
        Thread t1=new Thread(p,"车间一");
        Thread t2=new Thread(p,"车间二");
        Thread t3=new Thread(p,"车间三");
        Thread t4=new Thread(p,"车间四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Produce implements Runnable{
    int n=800;
    int a=0;
    public void run(){
        int a=0;
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        while(n>0){
            if(product()==0){
                a++;
            }
        }
        System.out.println(Thread.currentThread().getName()+"生产了:"+a);
    }
    public synchronized int product(){ //使用关键字synchronized修饰方法实现同步
        if(n>0){
            System.out.println("剩余生产任务量："+n--);
            return 0;
        }
        return 1;
    }
}
