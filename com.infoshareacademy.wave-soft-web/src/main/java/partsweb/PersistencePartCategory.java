package partsweb;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
}
