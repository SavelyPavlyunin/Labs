public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"10", "20", "30", "50"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                int number = Integer.parseInt(arr[i]);
                sum += number;
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: Выход за границы массива. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Элемент массива не является числом. " + e.getMessage());
        } finally {
            if (count > 0) {
                System.out.println("Среднее арифметическое: " + (double) sum / count);
            }
        }
    }
}
