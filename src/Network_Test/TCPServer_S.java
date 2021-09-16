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
                OutputStream ops = s.getOutputStream();
                String str = "Welcome to Hive 20.04 LTS\n"
                        + " * Documentation:  https://help.ubuntu.com\n" +
                        " * Management:     https://landscape.canonical.com\n" +
                        " * Support:        https://ubuntu.com/advantage\n"
                        + "System information as of Thu Sep 16 20:22:26 CST 2021"
                        + "0 updates can be installed immediately.\n" +
                        "0 of these updates are security updates.\n";
                ops.write(str.getBytes());
                ops.close();
                s.close();
            }
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
