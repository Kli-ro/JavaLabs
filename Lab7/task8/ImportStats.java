package Lab7.task8;

import java.util.List;

public class ImportStats {
    private final int totalLines;
    private final int successLines;
    private final int errorLines;
    private final boolean cancelled;
    private final List<String> errors;

    public ImportStats(int totalLines, int successLines, int errorLines, boolean cancelled, List<String> errors) {
        this.totalLines = totalLines;
        this.successLines = successLines;
        this.errorLines = errorLines;
        this.cancelled = cancelled;
        this.errors = errors;
    }

    public void printReport() {
        System.out.println("Всего строк прочитано: " + totalLines);
        System.out.println("Импортировано: " + successLines);
        System.out.println("Ошибочных строк: " + errorLines);
        if (cancelled) {
            System.out.println("Импорт отменён, превышен порог ошибок");
        }
        System.out.println("Сохранённые ошибки: "  + errors.size());
        for (String error : errors) {
            System.out.println("  " + error);
        }
    }
}