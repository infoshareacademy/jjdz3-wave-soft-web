import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Default
public class PersistenceUserStorage {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<UsersList> getAllUsers() {
        List<UsersList> usersList = em
                .createQuery("select p from UsersList p", UsersList.class)
                .getResultList();
        return usersList;

    }


}



