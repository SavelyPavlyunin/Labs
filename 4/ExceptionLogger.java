import java.io.*;
import java.util.Date;

public class ExceptionLogger {
    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter("exception_log.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(new Date() + " | Исключение: " + e.toString());
            pw.println("Сообщение: " + e.getMessage());
            pw.println("------------------------------------");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
