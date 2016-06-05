package practice0509;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
//@WebServlet("/User.view")
public class User extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                      throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("login") == null) {
            response.sendRedirect("login.html");
        } else {
            /* Settings for Chinese characters*/
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            /* Get print writer */
            PrintWriter out = response.getWriter();

            /* Output the web content */
            String htmlTemplate =
                  "<!DOCTYPE html>"
                + "<html>"
                + "    <head>"
                + "        <meta http-equiv=\"content-type\""
                + "            content=\"text/html; charset=utf-8\">"
                + "        <title>Welcome</title>"
                + "    </head>"
                + "    <body>"
                + "        <h1>Hello, %s</h1>"
                + "        <a href=\"Logout.view\">Logout</a></body>"
                + "    </body>"
            + "</html>";
            String html = String.format(htmlTemplate, session.getAttribute("login"));
            out.print(html);
            out.close();
        }
    }
}
