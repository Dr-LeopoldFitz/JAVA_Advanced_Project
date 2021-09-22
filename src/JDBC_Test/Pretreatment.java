package JDBC_Test;

import java.sql.*;

/**
 * @author Hive
 * Description:预处理语句动态地获取指定编号的同学信息
 * Date: 2021/9/22 14:09
 */

public class Pretreatment {
    static Connection con; // 声明Connection对象
    static PreparedStatement sql; // 声明预处理对象
    static ResultSet res; // 声明结果集对象
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
        Pretreatment c = new Pretreatment();
        con = c.getConnection(); // 获取与数据库的连接
        try {
            // 实例化预处理对象
            sql = con.prepareStatement("select * from Student"
                    + " where Sno = ?");
            sql.setString(1, "201215122"); // 设置参数
            res = sql.executeQuery(); // 执行预处理语句
            // 如果当前记录不是结果集中最后一行，则进入循环体
            while (res.next()) {
                String id = res.getString(1); // 获取结果集中第一列的值
                String name = res.getString("Sname");
                String sex = res.getString("SSex");
                String age = res.getString("Sage");
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
