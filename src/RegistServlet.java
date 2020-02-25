import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginDAO;
import model.DbUtil;
import model.User;

public class RegistServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        //获取注册用户名
        String username = req.getParameter("username");
        //获取注册用户密码
        String password = req.getParameter("password");

        DbUtil db = new DbUtil();
        User user = new User(username, password);
        LoginDAO loginDao = new LoginDAO();
        try {
            //数据库链接
            Connection con = db.getCon();

            if (loginDao.check(con, user)) {
                if (loginDao.regist(con,user)) {
                    out.print("<script language='JavaScript'>alert('注册成功，前往登录！！！');location.href='login.jsp';</script>");
                }
            } else {
                out.print("<script language='JavaScript'>alert('用户名已存在,请重新输入！！！');location.href='regist.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}