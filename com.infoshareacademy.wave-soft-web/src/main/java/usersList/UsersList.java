package usersList;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "serviceusers")
public class UsersList implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date entryDate;

    @Column(name = "firstname", length = 30)
    private String firstname;

    @Column(name = "lastname", length = 30)
    private String lastname;

    @Column(name = "email", length = 40, unique = true)
    private String email;

    @Column(name = "role", length = 1)
    private Integer role;

//    @OneToMany(mappedBy ="usersList" )
//    private List<PersistenceStatsReport> persistenceStatsReport = new ArrayList<>();

    public UsersList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

//    public List<PersistenceStatsReport> getPersistenceStatsReport() {
//        return persistenceStatsReport;
//    }
//
//    public void setPersistenceStatsReport(List<PersistenceStatsReport> persistenceStatsReport) {
//        this.persistenceStatsReport = persistenceStatsReport;
//    }
}

