package Lab7.task6;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class TempFileMove {
    public static void main(String[] args) {
        Path targetFile = Path.of("target_data.txt");
        Path tempFile = null;

        try {
            tempFile = Files.createTempFile("my_temp_", ".tmp");

            try (FileWriter openFile = new FileWriter(tempFile.toFile());
                 BufferedWriter pasteWrite = new BufferedWriter(openFile)) {
                pasteWrite.write("Новый каталог курсов");
                pasteWrite.newLine();
                pasteWrite.write("Курс_1: Java");
                pasteWrite.newLine();
                pasteWrite.write("Курс_2: Python");
            }

            System.out.println("Данные записаны во временный файл: " + tempFile);

            try {
                Files.move(tempFile, targetFile, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Файл заменён");
            } catch (AtomicMoveNotSupportedException ex) {
                System.out.println("Atomic move не поддерживается");
                Files.move(tempFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Файл заменён обычным move");
            }

        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода: " + ex.getMessage());
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException ex) {
                    System.out.println("Не удалось удалить временный файл: " + ex.getMessage());
                }
            }
        }
    }
}