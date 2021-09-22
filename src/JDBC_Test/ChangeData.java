package JDBC_Test;

import java.sql.*;

/**
 * @author Hive
 * Description:添加、修改、删除操作
 * Date: 2021/9/22 14:25
 */

public class ChangeData {
    static Connection con; // 声明Connection对象
    static PreparedStatement sql; // 声明PreparedStatement对象
    static ResultSet res; // 声明ResultSet对象

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:"
                    + "//127.0.0.1:3306/hive", "root", "pxl531");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        ChangeData c = new ChangeData();
        con = c.getConnection(); // 调用连接数据库方法
        try {
            sql = con.prepareStatement("select * from Course"); // 查询数据库
            res = sql.executeQuery(); // 执行SQL语句
            System.out.println("执行增加、修改、删除前数据:");
            while (res.next()) {
                String id = res.getString(1);
                String name = res.getString("Cname");
                String cp = res.getString("Cpno");
                int credit = res.getInt("Ccredit");
                System.out.print("编号：" + id);
                System.out.print(" 课程名：" + name);
                System.out.print(" 先修课:" + cp);
                System.out.println(" 学分：" + credit);
            }
            sql = con.prepareStatement("insert into Course(Cno,Cname,Cpno,Ccredit) values(?,?,?,?)");
            sql.setString(1, "531"); // 预处理添加数据
            sql.setString(2, "阿兹卡班越狱课");
            sql.setString(3, null);
            sql.setInt(4, 10);
            sql.executeUpdate();
            sql = con.prepareStatement("update Course set Ccredit "
                    + "= ? where Cno = ? ");
            sql.setString(1, "15"); // 更新数据
            sql.setString(2, "531"); // 更新数据
            sql.executeUpdate();
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("delete from Course where Cno = 2");
            //此表中含外键，无法删除
            // 查询修改数据后的tb_stu表中数据
            sql = con.prepareStatement("select * from Course");
            res = sql.executeQuery(); // 执行SQL语句
            System.out.println("执行增加、修改后的数据:");
            while (res.next()) {
                String id = res.getString(1);
                String name = res.getString("Cname");
                String cp = res.getString("Cpno");
                int credit = res.getInt("Ccredit");
                System.out.print("编号：" + id);
                System.out.print(" 课程名：" + name);
                System.out.print(" 先修课:" + cp);
                System.out.println(" 学分：" + credit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
执行增加、修改、删除前数据:
编号：1 课程名：数据库 先修课:5 学分：4
编号：2 课程名：数学 先修课:null 学分：2
编号：3 课程名：信息系统 先修课:1 学分：4
编号：4 课程名：操作系统 先修课:6 学分：3
编号：5 课程名：数据结构 先修课:7 学分：4
编号：6 课程名：数据处理 先修课:null 学分：2
编号：7 课程名：PASCAL语言 先修课:6 学分：4
执行增加、修改后的数据:
编号：1 课程名：数据库 先修课:5 学分：4
编号：2 课程名：数学 先修课:null 学分：2
编号：3 课程名：信息系统 先修课:1 学分：4
编号：4 课程名：操作系统 先修课:6 学分：3
编号：5 课程名：数据结构 先修课:7 学分：4
编号：531 课程名：阿兹卡班越狱课 先修课:null 学分：15
编号：6 课程名：数据处理 先修课:null 学分：2
编号：7 课程名：PASCAL语言 先修课:6 学分：4
*/