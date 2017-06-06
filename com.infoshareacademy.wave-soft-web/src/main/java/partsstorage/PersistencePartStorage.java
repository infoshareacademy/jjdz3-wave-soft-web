package partsstorage;


import WaveSoftProgram.parts.PlaceInCar;
import partsweb.PersistencePlaceInCar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
