import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args) {
        String password = "Password123";
        String regex = "^(?=.*[0-9])(?=.*[A-Z])[A-Za-z0-9]{8,16}$";

        if (Pattern.matches(regex, password)) {
            System.out.println("Пароль корректен.");
        } else {
            System.out.println("Пароль не соответствует требованиям.");
        }
    }
}
