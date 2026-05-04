import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class MatrixMaxExecutor {
    public static void main(String[] args) throws Exception {
        int[][] matrix = {{12, 45, 7}, {88, 32, 19}, {5, 67, 21}};
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int[] row : matrix) {
            futures.add(executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int v : row) if (v > max) max = v;
                return max;
            }));
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> f : futures) {
            int res = f.get();
            if (res > globalMax) globalMax = res;
        }
        executor.shutdown();

        System.out.println("Максимум: " + globalMax);
    }
}
