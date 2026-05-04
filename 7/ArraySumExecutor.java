import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class ArraySumExecutor {
    public static void main(String[] args) throws Exception {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Long>> futures = new ArrayList<>();

        int mid = numbers.length / 2;
        int[][] ranges = {{0, mid}, {mid, numbers.length}};

        for (int[] range : ranges) {
            futures.add(executor.submit(() -> {
                long s = 0;
                for (int i = range[0]; i < range[1]; i++) s += numbers[i];
                return s;
            }));
        }

        long totalSum = 0;
        for (Future<Long> f : futures) totalSum += f.get();
        executor.shutdown();

        System.out.println("Сумма: " + totalSum);
    }
}
