package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/login?useSSL=false&serverTimezone=UTC";
    private String dbUsername = "root";
    private String dbPassword = "123456";
    private String jdbcName = "com.mysql.cj.jdbc.Driver";

    public Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        return con;
    }
    //关闭
    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }
    //测试是否连接数据库
    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
