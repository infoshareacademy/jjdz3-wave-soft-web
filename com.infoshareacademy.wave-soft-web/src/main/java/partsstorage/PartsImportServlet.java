package partsstorage;

import WaveSoftProgram.parts.PartParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/partimport")
public class PartsImportServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PartParser partParser = new PartParser("/parts_ebay.json");

        PartsImport partsImport = new PartsImport();
        partsImport.partImport(partParser.getPlaceInCarList());

    }
}
