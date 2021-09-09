package Multithreading_Test;

/**
 * @author Hive
 * Description:
 * Date: 2021/9/8 21:48
 */
public class InterruptedTest implements Runnable{
    private boolean isContinue=false;
    public void run(){
        while(true){
            //...
            if(isContinue){
                break;
            }
        }
    }
    public void setContinue(){
        this.isContinue=true;
    }

    public static void main(String[] args) {
        InterruptedTest inter=new InterruptedTest();
    }
}
