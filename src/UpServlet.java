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

@WebServlet(name = "UpServlet")
public class UpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        DbUtil db = new DbUtil();
        StuDAO stuDAO = new StuDAO();
        Student student = new Student();
        student.setId(id);
        try {
            //数据库连接
            Connection con = db.getCon();

            if (stuDAO.findOne(con,student)!= null) {
                request.getSession().setAttribute("id",student.getId());
                request.getSession().setAttribute("name",student.getName());
                request.getSession().setAttribute("age",student.getAge());
                request.getSession().setAttribute("home",student.getHome());

                response.sendRedirect("upStu.jsp");
            }else {
                out.println("单个查询失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
