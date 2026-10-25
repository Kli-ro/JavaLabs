package Lab7.task7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCatalog {
    public static void main(String[] args) {
        String fileName = "import_data.txt";

        ImportResult result = importCatalog(fileName);
        result.printReport();
    }

    public static ImportResult importCatalog(String fileName) {
        List<String> importedData = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        try (FileReader openFile = new FileReader(fileName);
             BufferedReader pasteRead = new BufferedReader(openFile)) {

            String line;
            int lineNumber = 0;

            while ((line = pasteRead.readLine()) != null) {
                lineNumber++;

                if (line.isBlank()) {
                    errors.add("Строка " + lineNumber + ": пустая строка");
                    continue;
                }

                if (!line.contains(":")) {
                    errors.add("Строка " + lineNumber + ": отсутствует ':'");
                    continue;
                }

                importedData.add(line);
            }

        } catch (IOException ex) {
            errors.add("Ошибка чтения файла: " + ex.getMessage());
        }

        return new ImportResult(importedData, errors);
    }
}