package partsstorage;



import partsweb.PersistencePart;
import partsweb.PersistencePartCategory;
import partsweb.PersistencePlaceInCar;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<PersistencePlaceInCar> chooseOnePlace(Long id){
        List<PersistencePlaceInCar> persistencePlaceInCarList = new ArrayList<>();
        PersistencePlaceInCar persistencePlaceInCar = em
                .createQuery("select p from PersistencePlaceInCar p where p.id =:id", PersistencePlaceInCar.class)
                .setParameter("id", id)
                .getSingleResult();
        persistencePlaceInCarList.add(persistencePlaceInCar);
        return persistencePlaceInCarList;
    }

    @Transactional
    public List<PersistencePartCategory> chooseCategory(Long id){
        List<PersistencePartCategory> persistencePartCategoryList = em
                .createQuery("select p from PersistencePartCategory p left join fetch p.placeInCar t  where t.id =:id", PersistencePartCategory.class)
                .setParameter("id", id)
                .getResultList();
        return persistencePartCategoryList;
    }

    @Transactional
    public List<PersistencePartCategory> chooseOneCategory(Long id){
        List<PersistencePartCategory> persistencePartCategoryList = new ArrayList<>();
        PersistencePartCategory persistencePartCategory = em
                .createQuery("select p from PersistencePartCategory p where p.id =:id", PersistencePartCategory.class)
                .setParameter("id", id)
                .getSingleResult();
        persistencePartCategoryList.add(persistencePartCategory);
        return persistencePartCategoryList;
    }


    @Transactional
    public List<PersistencePart> choosePart(Long id){
        List<PersistencePart> persistencePartList = em
                .createQuery("select p from PersistencePart p left join fetch p.partCategory t  where t.id =:id", PersistencePart.class)
                .setParameter("id", id)
                .getResultList();
        return persistencePartList;
    }

    @Transactional
    public List<PersistencePart> chooseOnePart(Long id){
        List<PersistencePart> persistencePartList = new ArrayList<>();
        PersistencePart persistencePart = em
                .createQuery("select p from PersistencePart p where p.id =:id", PersistencePart.class)
                .setParameter("id", id)
                .getSingleResult();
        persistencePartList.add(persistencePart);
        return persistencePartList;
    }
}
