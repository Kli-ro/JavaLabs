package Lab7.task7;

import java.util.List;

public class ImportResult {
    private final List<String> importedData;
    private final List<String> errors;

    public ImportResult(List<String> importedData, List<String> errors) {
        this.importedData = importedData;
        this.errors = errors;
    }

    public List<String> getImportedData() {
        return importedData;
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean isFullySuccessful() {
        return errors.isEmpty();
    }

    public void printReport() {
        System.out.println("Успешно импортировано записей: " + importedData.size());
        if (!errors.isEmpty()) {
            System.out.println("Обнаружены ошибки: " + errors.size());
            for (String error : errors) {
                System.out.println("  " + error);
            }
        } else {
            System.out.println("Ошибок не обнаружено");
        }
    }
}