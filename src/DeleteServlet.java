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

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        DbUtil db = new DbUtil();
        Student student = new Student(id);
        StuDAO stuDAO = new StuDAO();
        try {
            //数据库连接
            Connection con = db.getCon();

            if (stuDAO.delete(con,student)) {
                List<Student> list = stuDAO.findAll(con,student);
                request.getSession().setAttribute("list",list);
                response.sendRedirect("success.jsp");
            }else {
                out.println("删除失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
