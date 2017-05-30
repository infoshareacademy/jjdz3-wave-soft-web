package partsweb;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class PersistencePartCategory {

    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;
    private List<PersistencePart> parts;
}
