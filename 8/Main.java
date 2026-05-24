import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            List<String> initialLines = List.of("  apple", "cat", "  banana  ", "ox", "cherry", "   ", "elderberry");
            Files.write(Paths.get(inputFile), initialLines);
        } catch (IOException e) {
            System.out.println("Не удалось создать тестовый файл, будут использованы дефолтные значения.");
        }

        DataManager dataManager = new DataManager();

        dataManager.registerDataProcessor(new FilterAndTransformProcessor());
        dataManager.registerDataProcessor(new SortAndSortProcessor());

        System.out.println("\n--- Шаг 1: Загрузка данных ---");
        dataManager.loadData(inputFile);

        System.out.println("\n--- Шаг 2: Параллельная обработка данных ---");
        dataManager.processData();

        System.out.println("\n--- Шаг 3: Сохранение результатов ---");
        dataManager.saveData(outputFile);
    }
}
