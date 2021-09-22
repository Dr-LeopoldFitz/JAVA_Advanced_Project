package JDBC_Test;

import java.sql.*;

/**
 * @author Hive
 * Description:将数据表Student中姓张的同学的信息检索出来，模糊查询
 * Date: 2021/9/22 10:43
 */

public class FuzzyQuery {
    static Connection con; // 声明Connection对象
    static Statement sql; // 声明Statement对象
    static ResultSet res; // 声明ResultSet对象

    public Connection getConnection() { // 与数据库连接方法
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:"
                    + "//127.0.0.1:3306/hive", "root", "pxl531");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con; // 返回Connection对象
    }

    public static void main(String[] args) {
        FuzzyQuery c = new FuzzyQuery(); // 创建本类对象
        con = c.getConnection(); // 获取与数据库的连接
        try {
            sql = con.createStatement(); // 实例化Statement对象
            res = sql
                    .executeQuery("select * from Student where Sname like '张%'");// 执行SQL语句
            while (res.next()) { // 如果当前记录不是结果集中的最后一条，进入循环体
                String id = res.getString(1); // 获取id字段值
                String name = res.getString("Sname"); // 获取name字段值
                String sex = res.getString("SSex"); // 获取sex字段值
                String age = res.getString("Sage"); // 获取age字段值
                System.out.print("编号：" + id); // 输出信息
                System.out.print(" 姓名：" + name);
                System.out.print(" 性别:" + sex);
                System.out.println(" 年龄：" + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
