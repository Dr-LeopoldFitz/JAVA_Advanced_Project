package JDBC_Test;

import java.sql.*;

/**
 * @author Hive
 * Description:在主方法中将数据表Student中的数据检索出来，顺序查询
 * Date: 2021/9/21 22:19
 */

public class SequenceQuery {
    static Connection con; // 声明Connection对象
    static Statement sql; // 声明Statement对象
    static ResultSet res; // 声明ResultSet对象

    public Connection getConnection() { // 连接数据库方法
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:"
                    + "//127.0.0.1:3306/hive", "root", "pxl531");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con; // 返回Connection对象
    }

    public static void main(String[] args) { // 主方法
        SequenceQuery c = new SequenceQuery(); // 创建本类对象
        con = c.getConnection(); // 与数据库建立连接
        try {
            sql = con.createStatement(); // 实例化Statement对象
            // 执行SQL语句，返回结果集
            res = sql.executeQuery("select * from Student");
            while (res.next()) { // 如果当前语句不是最后一条则进入循环
                String id = res.getString("Sno"); // 获取列名是"id"的字段值
                // 获取列名是"name"的字段值
                String name = res.getString("Sname");
                // 获取列名是"sex"的字段值
                String sex = res.getString("SSex");
                // 获取列名是"birthday"的字段值
                String age = res.getString("Sage");
                System.out.print("编号：" + id); // 将列值输出
                System.out.print("  姓名:" + name);
                System.out.print("  性别:" + sex);
                System.out.println("  年龄：" + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
+-----------+--------+------+------+-------+
| Sno       | Sname  | SSex | Sage | Sdept |
+-----------+--------+------+------+-------+
| 201215121 | 李勇   | 男   |   20 | CS    |
| 201215122 | 刘晨   | 女   |   19 | CS    |
| 201215123 | 王敏   | 女   |   18 | MA    |
| 201215125 | 张立   | 男   |   19 | IS    |
+-----------+--------+------+------+-------+
4 rows in set (0.00 sec)
*/