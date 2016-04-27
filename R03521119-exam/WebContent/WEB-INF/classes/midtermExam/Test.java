package midtermExam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
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
        out.println("<form action=\"Test\" method=\"post\">");

        out.println("<table border=\"0\">");

        out.println("<tr>");
        out.println("<th style=\"text-align:left\">名稱: </th>");
        out.println("<td><input type=\"text\" name=\"name\" required></td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<th style=\"text-align:left\">密碼: </th>");
        out.println("<td><input type=\"password\" name=\"password\" required></td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<br>");

        out.println("<input type=\"submit\" value=\"submit\">");
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
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Output Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td><b>The input username = " + request.getParameter("name") + "</td></b>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>The input password = " + request.getParameter("password") + "</td></b>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("<html>");
        out.close();
    }
}
