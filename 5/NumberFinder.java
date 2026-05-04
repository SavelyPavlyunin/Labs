import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Цена товара составляет 19.99, а скидка — 5 долларов. Вес: 1.5кг.";
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные числа:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
