package questionform;


import partsstorage.PersistencePartStorage;
import partsweb.PersistencePart;
import partsweb.PersistencePartCategory;
import partsweb.PersistencePlaceInCar;
import statsReport.PersistenceStatsReport;
import statsReport.PersistenceStatsReportStorage;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@WebServlet("/findpart")
public class FindPartServlet extends HttpServlet{
    @Inject
    @Default
    private PersistencePartStorage persistencePartStorage;
    private List<PersistencePlaceInCar> placeInCar;
    private List<PersistencePartCategory> partCategory;
    private List<PersistencePart> part;

    //pola potrzebne do zrobienia wpisu do tabeli ze statystykami
    @Inject
    @Default
    private PersistenceStatsReportStorage persistenceStatsReportStorage;
    private PersistenceStatsReport persistenceStatsReport;
//    private GregorianCalendar gregorianCalendar;

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

            //tworzenie nowego obiektu wpisu
            persistenceStatsReport = new PersistenceStatsReport();
            //dodawanie do obiektu raportu
            persistenceStatsReport.setPersistencePlaceInCar(this.placeInCar.get(0));

            req.setAttribute("placeInCar", this.placeInCar);
            req.setAttribute("partCategory", persistencePartStorage.chooseCategory(placeId));
        }

        String partCategory = req.getParameter("singlecategory");
        if (partCategory != null && !partCategory.isEmpty()){
            Long categoryId = Long.parseLong(partCategory);
            this.partCategory = persistencePartStorage.chooseOneCategory(categoryId);

            //dodawanie do obiektu raportu
            persistenceStatsReport.setPersistencePartCategory(this.partCategory.get(0));

            req.setAttribute("placeInCar", this.placeInCar);
            req.setAttribute("partCategory", this.partCategory);
            req.setAttribute("parts", persistencePartStorage.choosePart(categoryId));
        }

        String part = req.getParameter("singlepart");
        if (part != null && !part.isEmpty()){
            Long partId = Long.parseLong(part);
            this.part = persistencePartStorage.chooseOnePart(partId);

            //dodawanie do obiektu raportu
            persistenceStatsReport.setPersistencePart(this.part.get(0));

            req.setAttribute("placeInCar", this.placeInCar);
            req.setAttribute("partCategory", this.partCategory);
            req.setAttribute("parts", this.part);
            req.setAttribute("searchPhrase", this.part.get(0).getSearchPhrase());

            persistenceStatsReport.setWho("User");

            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            Calendar nowDate = Calendar.getInstance(timeZone);
            nowDate.get(Calendar.DATE);
            persistenceStatsReport.setCalendar(nowDate);

            //zapis raportu (1 wiersza) do tabeli
            persistenceStatsReportStorage.add(persistenceStatsReport);
        }
        req.getRequestDispatcher("findpart.jsp").forward(req, resp);
    }
}
