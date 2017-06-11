package adminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/adminStuff")
public class AdminServlet extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("loginAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameJsp = req.getParameter("nameJsp");
        String passwordJsp = req.getParameter("passwordJsp");

        boolean adminValid = loginService.adminAuth(nameJsp, passwordJsp);

        if (adminValid) {
            req.setAttribute("adminLogin", nameJsp);
            req.setAttribute("adminPassword", passwordJsp);
            req.getRequestDispatcher("welcomeAdmin.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "Invalid Credentials!");
            req.getRequestDispatcher("loginAdmin.jsp").forward(req, resp);
        }
    }
}