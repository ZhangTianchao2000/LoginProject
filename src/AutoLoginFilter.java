import model.CookieUtil;
import model.DbUtil;
import model.LoginDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;

@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        try {
            HttpServletRequest request = (HttpServletRequest) req;

            //先判断session中有无user
            User user = (User) request.getSession().getAttribute("user");
            //有，则有效，放行
            if(user != null){
                chain.doFilter(request, resp);
            }else {
                //session失效了

                //看cookie

                //来请求时，先取出cookie，但cookie里面有许多key-value
                Cookie[] cookies = request.getCookies();
                //从一堆cookie里面找到以前给浏览器发的cookie
                Cookie cookie = CookieUtil.findCookie(cookies,"auto_login");

                //第一次来
                if (cookie == null){
                    chain.doFilter(request,resp);
                }else {
                    String value = cookie.getValue();
                    String username = value.split("#")[0];
                    String password = value.split("#")[1];

                    User user1 = new User();
                    user1.setUsername(username);
                    user1.setPassword(password);

                    DbUtil db = new DbUtil();
                    //数据库连接
                    Connection con = db.getCon();
                    LoginDAO dao = new LoginDAO();
                    user = dao.login(con,user1);

                    //存到session中
                    request.getSession().setAttribute("user",user);

                    chain.doFilter(request,resp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            chain.doFilter(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
