package JDBC_Test;

import java.sql.*;

/**
 * @author Hive
 * Description:连接WSL MySQL
 * Date: 2021/9/21 21:38
 */


public class ConnectMySQL { // 创建类Conn
    Connection con; // 声明Connection对象

    public Connection getConnection() { // 建立返回值为Connection的方法
        try { // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try { // 通过访问数据库的URL获取数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql:"
                    + "//localhost:3306/mysql", "root", "pxl531");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con; // 按方法要求返回一个Connection对象
    }

    public static void main(String[] args) {
        ConnectMySQL c = new ConnectMySQL();
        c.getConnection(); // 调用连接数据库的方法
    }
}
