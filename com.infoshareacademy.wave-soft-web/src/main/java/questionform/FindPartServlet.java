package questionform;


import WaveSoftProgram.parts.PartParser;
import partsstorage.PartsImport;
import partsstorage.PersistencePartStorage;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findpart")
public class FindPartServlet extends HttpServlet{
    @Inject
    @Default
    private PersistencePartStorage persistencePartStorage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("placeInCar", persistencePartStorage.getAllPlaces());
        req.getRequestDispatcher("findpart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long placeId = Long.parseLong(req.getParameter("singleplace"));
        req.setAttribute("placeInCar", persistencePartStorage.choosePlace(placeId));
        req.setAttribute("partCategory", persistencePartStorage.chooseCategory(placeId));



        req.getRequestDispatcher("findpart.jsp").forward(req, resp);


        /*String placeInCar = req.getParameter("placeInCar");
        if (placeInCar != null && !placeInCar.isEmpty()){

        }*/
    }
}
