package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.net.URLEncoder;
import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataUploader
 */

// @WebServlet("/DataUploader")
// @MultipartConfig(location="/usr/local/tomcat/webapps/R03521119/resources/img")
public class DataUploader extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                      throws ServletException, IOException {

        /* Settings for Chinese characters*/
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        /* Get print writer */
        PrintWriter out = response.getWriter();

        /* Define some variables for creating output table */
        String[] headings = {"姓名: ", "住址: ", "電話: ", "生日: ", "學歷: ", "運動: ", "靜態休閒: ", "自傳: "};
        String[] names = {"name", "address", "phone", "birthday", "education", "sport", "passive leisure", "autobiography"};
        String[] values;    /* This variable is used to store the values in each input parameter */
        int i, j;

        /* Upload photo */
        Part part = request.getPart("photo");
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(
            header.indexOf("filename=\"") + 10,
            header.lastIndexOf("\""));
        filename = URLEncoder.encode(filename, "UTF-8").replace("%", "");
        part.write(filename);

        /* Output the web content */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Show Result</title>");
        out.println("<link rel=\"stylesheet\" href=\"resources/css/dataUploader.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th width=\"30%\">照片</th>");
        out.println("<th width=\"70%\">詳細資料</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td rowspan=\"" + headings.length + 3 + "\">");
        out.println("<img src=\"resources/img/" + filename + "\" height=\"250\" width=\"200\">");
        out.println("</td>");
        for (i = 0; i < headings.length; i++) {
            if (i != 0) out.println("<tr>");
            out.println("<td>");
            out.println("&nbsp&nbsp"  + headings[i]);
            values = request.getParameterValues(names[i]);
            if (values != null) for (j = 0; j < values.length; j++) out.println(values[j]);
            out.println("</td>");
            out.println("</tr>");
        }

        Date date = new Date();     /* Get current time */
        out.println("<tr>");
        out.println("<td>");
        out.println("&nbsp&nbsp登入個人資料時間: " + date.toString() + "<br><br>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("&nbsp&nbsp使用者端的來源IP: " + request.getRemoteAddr() +  "<br><br>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("&nbsp&nbsp使用者端的瀏覽器類型: " + request.getHeader("user-agent") +  "<br><br>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("<html>");
        out.close();
    }
}
