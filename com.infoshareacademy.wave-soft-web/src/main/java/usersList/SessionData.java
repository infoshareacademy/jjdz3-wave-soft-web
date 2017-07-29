package usersList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionData implements Serializable {

    private String firstname;
    private String lastname;
    private String picture;
    private String email;
    private boolean logged = false;
    private String partCategory = "";
    private boolean admin = false;

    public void logUser(String firstname, String lastname, String picture, String email, int role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.picture = picture;
        this.email = email;
        this.admin=(role==1)?true:false;
        this.logged = true;
    }

    public boolean isLogged() {
        return logged;
    }

    public boolean isAdmin() {
        return admin;
    }
    
    public void logout() {
        firstname = null;
        lastname = null;
        picture = null;
        email = null;
        logged = false;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public String getPartCategory() {
        return partCategory;
    }

    public void setPartCategory(String partCategory) {
        this.partCategory = partCategory;
    }

    @Override
    public String toString() {
        return "usersList.SessionData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", picture='" + picture + '\'' +
                ", email='" + email + '\'' +
                ", logged=" + logged +
                '}';
    }

}

