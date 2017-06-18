package partsweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PersistencePlaceInCar {
    @Id
    @GeneratedValue
    private Long id;
    private String nameOfPlace;

    @OneToMany(mappedBy = "placeInCar")
    private List<PersistencePartCategory> categories = new ArrayList<>();

    public PersistencePlaceInCar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfPlace() {
        return nameOfPlace;
    }

    public void setNameOfPlace(String nameOfPlace) {
        this.nameOfPlace = nameOfPlace;
    }

    public List<PersistencePartCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PersistencePartCategory> categories) {
        this.categories = categories;
    }
}
