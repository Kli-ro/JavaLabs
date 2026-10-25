package Lab7.task8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamImport {
    public static void main(String[] args) {
        String fileName = "big_import.txt";

        ImportStats stats = streamImport(fileName);
        stats.printReport();
    }

    public static ImportStats streamImport(String fileName) {
        int maxSavedErrors = 5;
        int cancelThreshold = 10;

        int totalLines = 0;
        int successLines = 0;
        int errorLines = 0;
        boolean cancelled = false;
        List<String> savedErrors = new ArrayList<>();

        try (FileReader openFile = new FileReader(fileName);
             BufferedReader pasteRead = new BufferedReader(openFile)) {

            String line;
            while ((line = pasteRead.readLine()) != null) {
                totalLines++;

                if (line.isBlank() || !line.contains(":")) {
                    errorLines++;

                    if (savedErrors.size() < maxSavedErrors) {
                        savedErrors.add("Строка " + totalLines + ": " + line);
                    }

                    if (errorLines >= cancelThreshold) {
                        cancelled = true;
                        break;
                    }

                    continue;
                }

                successLines++;
            }

        } catch (IOException ex) {
            savedErrors.add("Ошибка чтения файла: " + ex.getMessage());
        }

        return new ImportStats(totalLines, successLines, errorLines, cancelled, savedErrors);
    }
}