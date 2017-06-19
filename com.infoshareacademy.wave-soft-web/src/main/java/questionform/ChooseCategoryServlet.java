package questionform;

import partsstorage.PersistencePartStorage;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/choosecategory")
public class ChooseCategoryServlet extends HttpServlet {
    @Inject
    @Default
    private PersistencePartStorage persistencePartStorage;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("singleplace"));
        req.setAttribute("partCategory", persistencePartStorage.chooseCategory(id));
        req.getRequestDispatcher("findpart.jsp").forward(req, resp); //TU


    }
}
