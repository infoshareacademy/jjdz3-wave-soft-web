public class UserValidationService {
    public boolean isUserValid(String name, String password) {
        if(name.equals("mateusz@gmail.com") && password.equals("darth"))
            return true;

        return false;
    }
}

