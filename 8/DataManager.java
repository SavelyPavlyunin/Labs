import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DataManager {
    private List<String> rawData = new ArrayList<>();

    private final List<String> processedData = Collections.synchronizedList(new ArrayList<>());

    private final List<Object> processors = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
        System.out.println("Зарегистрирован процессор: " + processor.getClass().getSimpleName());
    }

    public void loadData(String source) {
        try {
            rawData = Files.readAllLines(Paths.get(source));
            System.out.println("Данные успешно загружены. Строк: " + rawData.size());
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке данных: " + e.getMessage());
            rawData = List.of("  apple ", " go ", "banana", " pear", "cherry", "kiwi");
            System.out.println("Загружены дефолтные данные: " + rawData);
        }
    }

    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Object processor : processors) {
            Method[] methods = processor.getClass().getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    DataProcessor annotation = method.getAnnotation(DataProcessor.class);
                    String processorName = annotation.name();

                    executorService.submit(() -> {
                        try {
                            System.out.println("[" + Thread.currentThread().getName() + "] Запуск процессора: " + processorName);

                            @SuppressWarnings("unchecked")
                            List<String> result = (List<String>) method.invoke(processor, rawData);

                            processedData.addAll(result);

                            System.out.println("[" + Thread.currentThread().getName() + "] Процессор " + processorName + " завершил работу. Найдено элементов: " + result.size());
                        } catch (Exception e) {
                            System.err.println("Ошибка при выполнении метода " + method.getName() + ": " + e.getMessage());
                        }
                    });
                }
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("Потоки не успели завершить работу вовремя.");
            }
        } catch (InterruptedException e) {
            System.err.println("Поток ожидания был прерван: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void saveData(String destination) {
        try {
            Files.write(Paths.get(destination), processedData);
            System.out.println("Результаты успешно сохранены в файл: " + destination);
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении данных: " + e.getMessage());
            System.out.println("Финальный результат в памяти: " + processedData);
        }
    }
}
