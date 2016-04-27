package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */

//@WebServlet("/controller.do")
public class Controller extends HttpServlet {
    private Model model = new Model();
    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                      throws ServletException, IOException {

        /* Settings for Chinese characters*/
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        /* Analyze user input */
        String password = request.getParameter("password");
        Boolean isEqual = model.checkPassword(password);

        /* Forward the result to view */
        request.setAttribute("result", isEqual);
        request.getRequestDispatcher("view.do")
               .forward(request, response);
    }
}
