package apiclient;


import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ebaysearch")
public class EbayClientServlet extends HttpServlet {

    @Inject
    @Default
    private EbayClient ebayClient;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchPhrase = req.getParameter("searchPhrase");
        req.setAttribute("searchResultList", ebayClient.searchOnEbay(searchPhrase));
        req.getRequestDispatcher("partsearchresults.jsp").forward(req, resp);
    }
}
