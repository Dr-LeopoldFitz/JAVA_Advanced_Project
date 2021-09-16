package Network_Test;

import java.net.*;

/**
 * @author Hive
 * Description:获得指定端口的主机名、主机地址和本机地址。
 * Date: 2021/9/16 20:13
 */

public class MyHost {
    public static void main(String[] args) {
        InetAddress ip = null;

        try {
            ip = InetAddress.getByName("localhost");// 修改为指定的主机名称
            System.out.println("主机名：" + ip.getHostName());
            System.out.println("主机IP地址：" + ip.getHostAddress());
            System.out.println("本机IP地址："
                    + InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
