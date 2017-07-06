package statsReport;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
