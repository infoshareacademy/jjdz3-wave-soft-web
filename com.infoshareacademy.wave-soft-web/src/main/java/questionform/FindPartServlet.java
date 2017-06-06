package questionform;


import WaveSoftProgram.parts.PartParser;
import partsstorage.PartsImport;
import partsstorage.PersistencePartStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findpart")
public class FindPartServlet extends HttpServlet{
    private PersistencePartStorage persistencePartStorage = new PersistencePartStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PartParser partParser = new PartParser("parts_ebay.json");

        PartsImport partsImport = new PartsImport();
        partsImport.partImport(partParser.getPlaceInCarList());*/
        req.setAttribute("placeInCar", persistencePartStorage.getAllPlaces());
        req.getRequestDispatcher("findpart.jsp").forward(req, resp);
    }
}
