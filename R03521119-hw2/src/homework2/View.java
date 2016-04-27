package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */

//@WebServlet("/view.do")
public class View extends HttpServlet {
    private String htmlTemplate =
          "<!DOCTYPE html>"
        + "<html>"
        + "    <head>"
        + "        <meta http-equiv=\"content-type\""
        + "            content=\"text/html; charset=utf-8\">"
        + "        <title>Check Result</title>"
        + "        <script>"
        + "            function goBack() {"
        + "                window.history.back();"
        + "            }"
        + "        </script>"
        + "    </head>"
        + "    <body>"
        + "        <h2>%s</h2>"
        + "        <button onclick=\"goBack()\">回前頁</button>"
        + "    </body>"
        + "</html>";

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
        Boolean isEqual = (Boolean) request.getAttribute("result");
        String message = (isEqual) ? "登入密碼正確！" : "登入密碼錯誤！";
        String html = String.format(htmlTemplate, message);
        out.print(html);
        out.close();
    }
}
