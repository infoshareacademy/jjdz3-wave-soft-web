package partsweb;

import statsReport.PersistenceStatsReport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PersistencePart {

    @Id
    @GeneratedValue
    private Long id;
    private String partId;
    private String searchPhrase;

    @ManyToOne
    private PersistencePartCategory partCategory;

    @OneToMany(mappedBy = "persistencePart")
    private List<PersistenceStatsReport> persistenceStatsReport = new ArrayList<>();

    public PersistencePart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getSearchPhrase() {
        return searchPhrase;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public List<PersistenceStatsReport> getPersistenceStatsReport() {
        return persistenceStatsReport;
    }

    public void setPersistenceStatsReport(List<PersistenceStatsReport> persistenceStatsReport) {
        this.persistenceStatsReport = persistenceStatsReport;
    }
}
