package adminService;


public class LoginService {

    public boolean adminAuth(String user, String password) {

        if(user.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
}
