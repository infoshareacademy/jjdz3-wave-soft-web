package statsReport;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by piotr_gy on 06.07.17.
 */
@Default
public class PersistenceStatsReportStorage {

    @PersistenceContext
    private EntityManager em;

    //dodaje tylko gotowy raport (1 wiersz) do tabeli
    @Transactional
    public void add(PersistenceStatsReport persistenceStatsReport) {
        em.persist(persistenceStatsReport);
    }

//    @Transactional
//    public void addDate(PersistenceStatsReport persistenceStatsReport) {
//        Date nowDate = new Date();
//        persistenceStatsReport.setNewDate(nowDate);
//        em.persist(persistenceStatsReport);
//    }

    @Transactional
    public void addCalendar(PersistenceStatsReport persistenceStatsReport) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Calendar nowDate = Calendar.getInstance(timeZone);
        nowDate.get(Calendar.DATE);
        persistenceStatsReport.setCalendar(nowDate);
        em.persist(persistenceStatsReport);
    }

    @Transactional
    public List<PersistenceStatsReport> getData() {
        String getDataQueryString = "select p from PersistenceStatsReport p";
        List<PersistenceStatsReport> data = em
                .createQuery(getDataQueryString, PersistenceStatsReport.class)
                .getResultList();
        return data;

    }
}
