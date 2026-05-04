import java.util.regex.*;

public class IPAddressChecker {
    public static void main(String[] args) {
        String ip = "092.168.1.255";
        String segment = "([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
        String regex = "^" + segment + "\\." + segment + "\\." + segment + "\\." + segment + "$";

        if (Pattern.matches(regex, ip)) {
            System.out.println("IP-адрес корректен.");
        } else {
            System.out.println("Некорректный IP-адрес.");
        }
    }
}
