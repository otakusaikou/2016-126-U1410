package homework3.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework3.model.AccountCheck;
import homework3.model.User;

/**
 * Controller for user login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String jspPageToForward = null;

        // For CJK characters
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Get user database
        ServletContext context = request.getServletContext();
        @SuppressWarnings("unchecked")
        HashMap<String, User> userDB = (HashMap<String, User>) context.getAttribute("userDB");

        // Clear session and cookies when user click "return to home page" or "logout" links
        HttpSession session = request.getSession(false);
        Cookie[] cookies = request.getCookies();
        String action = request.getParameter("action");
        if ("logout".equals(action)) {
            if (session != null) {
                session.invalidate();
            }

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setPath(request.getContextPath());
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            response.sendRedirect(request.getContextPath());
            return;
        }

        // For the case where login buttion pressed
        String page = request.getParameter("submit");
        if ("送出".equals(page)) {
            String accountName = request.getParameter("accountName");
            // Check if the input account name exists
            if (AccountCheck.checkAccountNameExistence(accountName, userDB)) {
                String password = request.getParameter("password");
                // Check if the input password is correct
                if (AccountCheck.checkPassword(accountName, password, userDB)) {
                    // Get user information and write them as session attributes
                    User user = userDB.get(accountName);
                    session = request.getSession();
                    session.setAttribute("loginUser", user);

                    // Create cookies for auto login if the checkbox is checked
                    if (request.getParameter("autoLogin") != null) {
                        Cookie accountNameCookie = new Cookie("accountName", accountName);
                        accountNameCookie.setPath(request.getContextPath());
                        accountNameCookie.setHttpOnly(true);
                        accountNameCookie.setMaxAge(7 * 24 * 60 * 60);
                        response.addCookie(accountNameCookie);
                        Cookie passwordCookie = new Cookie("password", password);
                        passwordCookie.setPath(request.getContextPath());
                        passwordCookie.setHttpOnly(true);
                        passwordCookie.setMaxAge(7 * 24 * 60 * 60);
                        response.addCookie(passwordCookie);
                    }

                    jspPageToForward = "userLoginPage.jsp";
                } else {
                    request.setAttribute("errorCode", "輸入密碼錯誤!");
                    jspPageToForward = "login.jsp";
                }
            } else {
                request.setAttribute("errorCode", "輸入帳號錯誤, 查無此帳號！");
                jspPageToForward = "login.jsp";
            }
        // For checking the auto login event
        } else {
            // Grab information from cookies
            HashMap<String, String> userInfo = new HashMap<String, String>();
            cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    userInfo.put(cookie.getName(), cookie.getValue());
                }
            }

            // The case where the user access the home page normally
            String accountName = userInfo.get("accountName");
            String password = userInfo.get("password");
            if (accountName == null || password == null) {
                jspPageToForward = "login.jsp";
                RequestDispatcher dispatcher = request
                    .getRequestDispatcher(jspPageToForward);
                dispatcher.forward(request, response);
                return;
            }

            // Check account name and password in cookies
            if (AccountCheck.checkAccountNameExistence(accountName, userDB)) {
                if (AccountCheck.checkPassword(accountName, password, userDB)) {
                    User user = userDB.get(accountName);
                    session = request.getSession();
                    session.setAttribute("loginUser", user);
                    jspPageToForward = "userLoginPage.jsp";
                } else {
                    request.setAttribute("errorCode", "輸入密碼錯誤!");
                    jspPageToForward = "login.jsp";
                }
            } else {
                request.setAttribute("errorCode", "輸入帳號錯誤, 查無此帳號！");
                jspPageToForward = "login.jsp";
            }
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
