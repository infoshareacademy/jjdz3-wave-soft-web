package questionform;


import partsstorage.PersistencePartStorage;
import partsweb.PersistencePart;
import partsweb.PersistencePartCategory;
import partsweb.PersistencePlaceInCar;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findpart")
public class FindPartServlet extends HttpServlet{
    @Inject
    @Default
    private PersistencePartStorage persistencePartStorage;
    private List<PersistencePlaceInCar> placeInCar;
    private List<PersistencePartCategory> partCategory;
    private List<PersistencePart> part;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("placeInCar", persistencePartStorage.getAllPlaces());
        req.getRequestDispatcher("findpart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Long placeId = null;
        String placeInCar = req.getParameter("singleplace");
        if (placeInCar != null && !placeInCar.isEmpty()){
            Long placeId = Long.parseLong(placeInCar);
            this.placeInCar = persistencePartStorage.chooseOnePlace(placeId);
            req.setAttribute("placeInCar", this.placeInCar);
            req.setAttribute("partCategory", persistencePartStorage.chooseCategory(placeId));
        }

        String partCategory = req.getParameter("singlecategory");
        if (partCategory != null && !partCategory.isEmpty()){
            Long categoryId = Long.parseLong(partCategory);
            this.partCategory = persistencePartStorage.chooseOneCategory(categoryId);
            req.setAttribute("placeInCar", this.placeInCar);
            req.setAttribute("partCategory", this.partCategory);
            req.setAttribute("parts", persistencePartStorage.choosePart(categoryId));
        }

        String part = req.getParameter("singlepart");
        if (part != null && !part.isEmpty()){
            Long partId = Long.parseLong(part);
            this.part = persistencePartStorage.chooseOnePart(partId);
            req.setAttribute("placeInCar", this.placeInCar);
            req.setAttribute("partCategory", this.partCategory);
            req.setAttribute("parts", this.part);
            req.setAttribute("searchPhrase", this.part.get(0).getSearchPhrase());
        }
        req.getRequestDispatcher("findpart.jsp").forward(req, resp);
    }
}
