import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog";
        char startChar = 'f';

        String regex = "(?i)\\b" + startChar + "[\\w]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова на букву '" + startChar + "':");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
