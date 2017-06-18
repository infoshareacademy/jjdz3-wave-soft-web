package partsstorage;



import partsweb.PersistencePlaceInCar;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Default
public class PersistencePartStorage {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<PersistencePlaceInCar> getAllPlaces(){
        List<PersistencePlaceInCar> persistencePlaceInCarList = em
                .createQuery("select p from PersistencePlaceInCar p", PersistencePlaceInCar.class)
                .getResultList();
        return persistencePlaceInCarList;

    }
}
