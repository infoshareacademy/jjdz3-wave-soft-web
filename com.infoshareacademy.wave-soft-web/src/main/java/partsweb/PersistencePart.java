package partsweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PersistencePart {

    @Id
    @GeneratedValue
    private Long id;
    private String partId;
    private String searchPhrase;

    @ManyToOne
    private PersistencePartCategory partCategory;

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
}
