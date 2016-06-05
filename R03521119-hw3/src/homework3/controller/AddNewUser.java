package homework3.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework3.model.AccountCheck;
import homework3.model.User;

/**
 * Controller for creating new account
 */
@WebServlet("/createAccount.do")
public class AddNewUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Create a HashMap for storing the user information.
    private static HashMap<String, User> userDB = new HashMap<String, User>();

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String jspPageToForward = null;

        // For CJK characters
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("submit");

        // Store the user database to servlet context
        ServletContext context = request.getServletContext();
        context.setAttribute("userDB", userDB);

        if ("下一頁".equals(page)) {
            // Write information of page1 to session
            HttpSession session = request.getSession();
            session.setAttribute("name", request.getParameter("name"));
            session.setAttribute("address", request.getParameter("address"));
            session.setAttribute("phoneNumber", request.getParameter("phoneNumber"));
            session.setAttribute("education", request.getParameter("education"));
            jspPageToForward = "addAccountPage.jsp";
        } else if ("送出".equals(page)) {
            // Get information of page1 from session
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("name");
            String address = (String) session.getAttribute("address");
            String phoneNumber = (String) session.getAttribute("phoneNumber");
            String education = (String) session.getAttribute("education");
            String accountName = request.getParameter("accountName");
            String password = request.getParameter("password");

            // Account information (page2)
            session.setAttribute("accountName", accountName);
            session.setAttribute("password", password);

            // Check if the input account name exist in the user database
            if (AccountCheck.checkAccountNameExistence(accountName, userDB)) {
                request.setAttribute("errorCode", "所輸入的帳戶名稱已經有人使用, 請輸入另一個帳戶名稱！");
                jspPageToForward = "addAccountPage.jsp";
            } else {
                // Add new user object to user database (page3)
                AccountCheck.addNewUser(name, address, phoneNumber, education, accountName, password, userDB);
                jspPageToForward = "userInfoPage.jsp";
            }
        } else {
            // Show page1
            jspPageToForward = "addUserPage.jsp";
        }
        RequestDispatcher dispatcher = request
            .getRequestDispatcher(jspPageToForward);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
