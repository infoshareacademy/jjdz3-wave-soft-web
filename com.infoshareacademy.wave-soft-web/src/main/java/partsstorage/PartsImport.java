package partsstorage;


import WaveSoftProgram.parts.Part;
import WaveSoftProgram.parts.PartCategory;
import WaveSoftProgram.parts.PlaceInCar;
import partsweb.PersistencePart;
import partsweb.PersistencePartCategory;
import partsweb.PersistencePlaceInCar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class PartsImport {
    @PersistenceContext
    private EntityManager em;

    public PartsImport() {
        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "default" );
        em = entityManagerFactory.createEntityManager();*/
    }

    @Transactional
    public void partImport(List<PlaceInCar> placeInCarList){

        //odczytaj każdy element place_in_car
        for (PlaceInCar placeInCar : placeInCarList) {
            //odczytaj name_of_place
            PersistencePlaceInCar persistencePlaceInCar = new PersistencePlaceInCar();
            persistencePlaceInCar.setNameOfPlace(placeInCar.getNameOfPlace());

            //odczytaj każdy element part_category
            List<PersistencePartCategory> persistencePartCategoryList = new ArrayList<>(); //czy tu musi być, bo w definicji encji już jest new?
            persistencePlaceInCar.setCategories(persistencePartCategoryList);

            List<PartCategory> partCategoryList = placeInCar.getCategories();
            for (PartCategory partCategory : partCategoryList) {
                //odczytaj category_name
                PersistencePartCategory persistencePartCategory = new PersistencePartCategory();
                persistencePartCategory.setCategoryName(partCategory.getCategoryName());

                //odczytaj każdy element parts
                List<PersistencePart> persistencePartList = new ArrayList<>(); //jak wyżej - czy musi być?
                persistencePartCategory.setParts(persistencePartList);

                List<Part> partList = partCategory.getParts();
                for (Part part : partList) {
                    PersistencePart persistencePart = new PersistencePart();

                    //odczytaj part_id
                    persistencePart.setPartId(part.getPartId());
                    //odczytaj search_phrase
                    persistencePart.setSearchPhrase(part.getSearchPhrase());

                    em.persist(persistencePart);
                }

                em.persist(persistencePartCategory);
            }

            em.persist(persistencePlaceInCar);
        }

    }

}
