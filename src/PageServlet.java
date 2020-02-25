import model.DbUtil;
import model.Page;
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

@WebServlet(name = "PageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalSize;//总的记录数
        int totalPage;//总页数

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int page = Integer.parseInt(request.getParameter("page"));

        DbUtil db = new DbUtil();
        StuDAO stuDAO = new StuDAO();
        Page p = new Page();
        p.setPage(page);

        try {
            //数据库连接
            Connection con = db.getCon();

            if (stuDAO.page(con,p)!= null) {
                totalSize = stuDAO.total(con,p);
                if (totalSize%3==0){
                    totalPage = totalSize/3;
                }else totalPage = totalSize/3+1;
                List<Student> list = stuDAO.page(con,p);
                request.getSession().setAttribute("list",list);
                request.getSession().setAttribute("totalSize",totalSize);
                request.getSession().setAttribute("totalPage",totalPage);
                request.getSession().setAttribute("page",page);
                response.sendRedirect("pageStu.jsp");
            }else {
                out.println("分页查询失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
