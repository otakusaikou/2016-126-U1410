package practice0509;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
//@WebServlet("/Logout.view")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                      throws ServletException, IOException {
        /* Settings for Chinese characters*/
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("login");
        session.invalidate();

        /* Get print writer */
        PrintWriter out = response.getWriter();

        /* Output the web content */
        String htmlTemplate =
              "<!DOCTYPE html>"
            + "<html>"
            + "    <head>"
            + "        <meta http-equiv=\"content-type\""
            + "            content=\"text/html; charset=utf-8\">"
            + "        <title>Logout</title>"
            + "    </head>"
            + "    <body>"
            + "        <h1>Good Bye, %s!</h1>"
            + "    </body>"
        + "</html>";
        String html = String.format(htmlTemplate, user);
        out.print(html);
        out.close();
    }
}
