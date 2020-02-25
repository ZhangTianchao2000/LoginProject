import model.DbUtil;
import model.StuDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String age = request.getParameter("age");
        String home = request.getParameter("home");

        DbUtil db = new DbUtil();
        StuDAO stuDAO = new StuDAO();
        Student student = new Student();
        student.setAge(age);
        student.setHome(home);
        try {
            //数据库连接
            Connection con = db.getCon();

            if (stuDAO.findSome(con,student)!= null) {
                List<Student> list = stuDAO.findSome(con,student);
                request.getSession().setAttribute("list",list);
                response.sendRedirect("someStu.jsp");
            }else {
                out.println("模糊查询失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
