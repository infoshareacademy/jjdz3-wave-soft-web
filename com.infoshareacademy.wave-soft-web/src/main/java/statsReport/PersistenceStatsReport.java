package statsReport;

import partsweb.PersistencePart;
import partsweb.PersistencePartCategory;
import partsweb.PersistencePlaceInCar;

import javax.persistence.*;

@Entity
@Table(name="CATEGORY_REPORT")
public class PersistenceStatsReport {

    @Id
    @GeneratedValue
    private Long categoryId;

    @Column(name = "data")
    private Long date;

    @Column(name = "user")
    private String who;

    @OneToOne
    private PersistencePart persistencePart;

    @OneToOne
    private PersistencePartCategory persistencePartCategory;

    @OneToOne
    private PersistencePlaceInCar persistencePlaceInCar;

    public PersistenceStatsReport() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public PersistencePart getPersistencePart() {
        return persistencePart;
    }

    public void setPersistencePart(PersistencePart persistencePart) {
        this.persistencePart = persistencePart;
    }

    public PersistencePartCategory getPersistencePartCategory() {
        return persistencePartCategory;
    }

    public void setPersistencePartCategory(PersistencePartCategory persistencePartCategory) {
        this.persistencePartCategory = persistencePartCategory;
    }

    public PersistencePlaceInCar getPersistencePlaceInCar() {
        return persistencePlaceInCar;
    }

    public void setPersistencePlaceInCar(PersistencePlaceInCar persistencePlaceInCar) {
        this.persistencePlaceInCar = persistencePlaceInCar;
    }
}
