package practice0502;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
//@WebServlet("/Test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                      throws ServletException, IOException {

        /* Settings for Chinese characters*/
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        /* Get print writer */
        PrintWriter out = response.getWriter();

        /* Output the web content */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Input Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"0502\" method=\"post\">");
        out.println("<table border=\"0\">");
        out.println("<tr>");
        out.println("<th style=\"text-align:left\">Input your username: </th>");
        out.println("<td><input type=\"text\" name=\"name\" required></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<br>");
        out.println("<input type=\"submit\" value=\"next\">");
        out.println("<input type=\"hidden\" name=\"pageNumber\" value=\"1\">");
        out.println("</form");
        out.println("</body>");
        out.println("<html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                      throws ServletException, IOException {

        /* Settings for Chinese characters*/
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        /* Get print writer */
        PrintWriter out = response.getWriter();

        /* Output the web content */
        String fromPage = request.getParameter("pageNumber");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Input Page</title>");
        out.println("</head>");
        out.println("<body>");

        if (fromPage.equals("1")) {
            String name = request.getParameter("name");
            out.println("<form action=\"0502\" method=\"post\">");
            out.println("<table border=\"0\">");
            out.println("<tr>");
            out.println("<th style=\"text-align:left\">Input your password: </th>");
            out.println("<td><input type=\"password\" name=\"password\" required></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br>");
            out.println("<input type=\"submit\" name=\"page\" value=\"complete\">");
            out.println("<input type=\"hidden\" name=\"pageNumber\" value=\"2\">");
            out.println("<input type=\"hidden\" name=\"name\" value=\"" + name + "\">");
            out.println("</form");
        } else if (fromPage.equals("2")) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            out.println("<table border=\"0\">");
            out.println("<tr>");
            out.println("<td><b>The input username = " + name + "</td></b>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><b>The input password = " + password + "</td></b>");
            out.println("</tr>");
            out.println("</table>");
        }
        out.println("</body>");
        out.println("<html>");
        out.close();
    }
}
