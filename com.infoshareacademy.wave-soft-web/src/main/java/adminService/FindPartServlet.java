package adminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/finding", urlPatterns = { "/finding" })
public class FindPartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



   /*     resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<h2>Hello Friends! Welcome to the world of servlet annotation </h2>");
        out.write("<br/>");
        out.close();*/
                resp.sendRedirect("http://localhost:8080/autoparts/findPart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchedPart = req.getParameter("searchedPartName");
        List<FindPartService> findPartList = new ArrayList<FindPartService>();

        FindPartService findPartService = new FindPartService();
        findPartService.setPartName(searchedPart);
        findPartList.add(findPartService);
        req.setAttribute("findPartList", findPartList);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcomeAdmin.jsp");
        rd.forward(req, resp);

    }
}
