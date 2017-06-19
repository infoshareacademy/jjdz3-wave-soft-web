package partsstorage;



import partsweb.PersistencePartCategory;
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

    @Transactional
    public List<PersistencePartCategory> chooseCategory(Long id){
        List<PersistencePartCategory> persistencePartCategoryList = em
                .createQuery("select p from PersistencePartCategory p where p.placeInCar = :id", PersistencePartCategory.class)
                .getResultList();
        return persistencePartCategoryList;
    }
}
