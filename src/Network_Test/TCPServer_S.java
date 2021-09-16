package Network_Test;

import java.io.*;
import java.net.*;

/**
 * @author Hive
 * Description:
 * Date: 2021/9/16 20:17
 */

public class TCPServer_S {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8001);
            while (!ss.isClosed()) {
                Socket s = ss.accept();
                InputStream ips = s.getInputStream();
                OutputStream ops = s.getOutputStream();
                String str = "Welcome to Hive 20.04 LTS\n"
                        + " * Documentation:  https://help.ubuntu.com\n" +
                        " * Management:     https://landscape.canonical.com\n" +
                        " * Support:        https://ubuntu.com/advantage\n"
                        + "System information as of Thu Sep 16 20:22:26 CST 2021"
                        + "0 updates can be installed immediately.\n" +
                        "0 of these updates are security updates.\n";
                ops.write(str.getBytes());
                byte[] buf = new byte[1024];
                int len = 0;
                if (ips.available() > 0)
                    len = ips.read(buf);
                System.out.println(new String(buf, 0, len));
                ips.close();
                ops.close();
                s.close();
            }
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
