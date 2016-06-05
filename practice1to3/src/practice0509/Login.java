package practice0509;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login.do")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                      throws ServletException, IOException {

        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        if ("otakusaikou".equals(user) && "otaku".equals(passwd)) {
            request.getSession().setAttribute("login", user);
            /* Forward the result to view */
            request.getRequestDispatcher("User.view")
                   .forward(request, response);
        } else {
            response.sendRedirect("login.html");
        }
    }
}
