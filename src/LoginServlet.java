import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String autologin = req.getParameter("auto_login");

        DbUtil db = new DbUtil();
        User user = new User(username, password);
        LoginDAO loginDao = new LoginDAO();
        try {
            //数据库连接
            Connection con = db.getCon();

            if (loginDao.checkUser(con,user)) {
                if (loginDao.login(con, user) != null) {
                    if ("on".equals(autologin)){
                        //发送cookie给客户端
                        Cookie cookie = new Cookie("auto_login",username+"#"+password);
                        cookie.setMaxAge(60*60*24*7);
                        cookie.setPath(req.getContextPath());
                        resp.addCookie(cookie);
                    }
                    Student stu = new Student();
                    StuDAO stuDAO = new StuDAO();
                    List<Student> list = stuDAO.findAll(con, stu);
                    req.getSession().setAttribute("list", list);
                    resp.sendRedirect("success.jsp");
                } else {
                    out.print("<script language='JavaScript'>alert('密码不正确，请重新登录！！！');location.href='login.jsp';</script>");
                }
            }else {
                out.print("<script language='JavaScript'>alert('用户名不存在，请前往注册！！！');location.href='regist.jsp';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
