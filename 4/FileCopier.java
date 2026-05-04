import java.io.*;

public class FileCopier {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destPath = "destination.txt";

        try (FileInputStream in = new FileInputStream(sourcePath);
             FileOutputStream out = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            System.out.println("Файл успешно скопирован.");

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла. " + e.getMessage());
        }
    }
}
