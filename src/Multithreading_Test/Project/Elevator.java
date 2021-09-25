package Multithreading_Test.Project;

/**
 * @author Hive
 * Description:电梯最大载重量为1000千克，使用线程的中断模拟当乘客的总重量超过1000千克时，
 * 电梯发出预警提示音。假设乘客的平均体重为80千克
 * Date: 2021/9/24 14:32
 */

public class Elevator {
    public static void main(String[] args) {
        new Capacity().start();
    }
}

class Capacity extends Thread {
    int averWeight = 80;
    boolean flag = true;
    int totalWeight = 0;
    int passangerNum = 0;
    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
                totalWeight += averWeight;
                System.out.println("现电梯里已有乘客" + (++passangerNum) + "人。");
                if (totalWeight > 1000) {
                    interrupt();
                }
            } catch (InterruptedException e) {
                System.out.println("乘客的总重量已超过1000kg，电梯发出预警提示音……");
                System.out.println("电梯可容纳" + (passangerNum - 1) + "位体重为80kg的乘客。");
                flag = false;
            }
        }
    }
}