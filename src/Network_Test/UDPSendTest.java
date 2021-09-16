package Network_Test;

import java.net.*;

/**
 * @author Hive
 * Description:广播主机程序
 * Date: 2021/9/16 19:20
 */

public class UDPSendTest extends Thread { // 创建类。该类为多线程执行程序
    String weather = "节目预报：八点有大型晚会，请收听";
    int port = 9898; // 定义端口
    InetAddress iaddress = null; // 创建InetAddress对象
    MulticastSocket socket = null; // 声明多点广播套接字

    UDPSendTest() { // 构造方法
        try {
            // 实例化InetAddress，指定地址
            iaddress = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port); // 实例化多点广播套接字
            socket.setTimeToLive(1); // 指定发送范围是本地网络
            //设置在此多播套接字上发送的多播数据包的默认生存时间，以便控制多播的范围。
            socket.joinGroup(iaddress); // 加入广播组
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
    }

    public void run() { // run()方法
        while (true) {
            DatagramPacket packet = null; // 声明DatagramPacket对象
            byte data[] = weather.getBytes(); // 声明字节数组
            // 将数据打包
            packet = new DatagramPacket(data, data.length, iaddress, port);
            System.out.println(new String(data)); // 将广播信息输出
            try {
                socket.send(packet); // 发送数据
                sleep(3000); // 线程休眠
            } catch (Exception e) {
                e.printStackTrace(); // 输出异常信息
            }
        }
    }

    public static void main(String[] args) { // 主方法
        UDPSendTest w = new UDPSendTest(); // 创建本类对象
        w.start(); // 启动线程
    }
}
