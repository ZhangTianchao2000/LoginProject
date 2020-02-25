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

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //获取客户端提交上来的数据
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String home = request.getParameter("home");

        DbUtil db = new DbUtil();
        Student student = new Student(id,name,age,home);
        StuDAO stuDAO = new StuDAO();
        try {
            //数据库连接
            Connection con = db.getCon();

            if (stuDAO.update(con,student)) {
                List<Student> list = stuDAO.findAll(con,student);
                request.getSession().setAttribute("list",list);
                response.sendRedirect("success.jsp");
            }else {
                out.println("修改失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
