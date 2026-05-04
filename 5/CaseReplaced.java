import java.util.regex.*;

public class CaseReplaced {
    public static void main(String[] args) {
        String text = "javaIsFun and regularExpressionsAreCool";
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);

        String result = matcher.replaceAll("$1!$2!");
        System.out.println(result);
    }
}
