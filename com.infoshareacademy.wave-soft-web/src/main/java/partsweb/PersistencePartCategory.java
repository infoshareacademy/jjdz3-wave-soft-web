package partsweb;


import statsReport.PersistenceStatsReport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PersistencePartCategory {

    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;

    @OneToMany(mappedBy = "partCategory")
    private List<PersistencePart> parts = new ArrayList<>();

    @ManyToOne
    private PersistencePlaceInCar placeInCar;

    @OneToMany(mappedBy = "persistencePartCategory")
    private PersistenceStatsReport persistenceStatsReport;

    public PersistencePartCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<PersistencePart> getParts() {
        return parts;
    }

    public void setParts(List<PersistencePart> parts) {
        this.parts = parts;
    }

    public PersistenceStatsReport getPersistenceStatsReport() {
        return persistenceStatsReport;
    }

    public void setPersistenceStatsReport(PersistenceStatsReport persistenceStatsReport) {
        this.persistenceStatsReport = persistenceStatsReport;
    }
}
