import java.util.Scanner;

public class MathApp {
    public static double performOperation(double a, double b, String op)
            throws CustomUnsupportedOperationException {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                yield a / b;
            }
            default -> throw new CustomUnsupportedOperationException("Операция '" + op + "' не поддерживается.");
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите первое число: ");
            double x = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите второе число: ");
            double y = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите операцию (+, -, *, /): ");
            String operation = scanner.nextLine();

            System.out.println("Результат: " + performOperation(x, y, operation));

        } catch (CustomUnsupportedOperationException e) {
            System.err.println("Ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        } finally {
            scanner.close();
        }
    }
}
