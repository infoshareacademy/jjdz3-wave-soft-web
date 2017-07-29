package statsReport;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/statsReport")
public class StatsReportServlet extends HttpServlet {

    @Inject
    @Default
    private PersistenceStatsReportStorage persistenceStatsReportStorage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("reportTable" , persistenceStatsReportStorage.getData());
        req.getRequestDispatcher("statsReportView.jsp").forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String statsRepo = req.getParameter("valueForStatsReport");
////   <p>${firstStatReport}</p>
////                <%--<input type="hidden" name="statsRepo" value="${searchPhrase}" />--%>
//        req.setAttribute("firstStatReport", statsRepo);
//        req.getRequestDispatcher("welcomeAdmin.jsp").forward(req, resp);
//    }
}
