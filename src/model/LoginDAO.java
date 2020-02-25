package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    //登录功能
    public User login(Connection con, User user) throws Exception {
        User resultUser = null;
        String sql = "select * from user_table where username=? and password=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultUser = new User();
            resultUser.setUsername(rs.getString("username"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }

    //注册功能
    public boolean regist(Connection con, User user) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO user_table(username,password)VALUES(?,?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        if (pstmt.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }

    //检测用户名是否重复
    public boolean check(Connection con, User user) throws Exception {
        boolean flag = true;
        PreparedStatement pstmt = null;
        String sql = "SELECT COUNT(*) AS cont FROM user_table WHERE username = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            if (rs.getInt("cont")>1){
                flag = false;
            }
        }
        return flag;
    }

    //检测是否存在用户名
    public boolean checkUser(Connection con, User user) throws Exception {
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM user_table WHERE username = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
           flag = true;
        }
        return flag;
    }

    //自动登录

}