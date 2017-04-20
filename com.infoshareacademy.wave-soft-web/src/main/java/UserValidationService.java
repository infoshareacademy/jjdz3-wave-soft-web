public class UserValidationService {
    public boolean isUserValid(String user, String password) {
        if(user.equals("mateusz@gmail.com") && password.equals("darth"))
            return true;

        return false;
    }
}

