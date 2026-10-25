package Lab7.task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class FileRead {
    public static void main(String[] args) {
        try {

            // path to file
            Path path = Path.of("course.txt");

            // hand over any text
            Files.writeString(path, "Каталог курсов:\nКурс_1: Java\nКурс_2: C\nКурс_3: JavaScript", StandardCharsets.UTF_8);
            System.out.println("Текст в файл записан");

            // reading and outputting text
            String textFile = Files.readString(path, StandardCharsets.UTF_8);
            System.out.println(textFile);
            System.out.println("Текст выведен из файла");


        // fail file physic doesnt exist in path
        } catch (NoSuchFileException ex) {
            // process fail, printStackTrace - for creator
            ex.printStackTrace();
            System.out.println("Ошибка чтения файла");
            System.exit(1);

        // fail all FS
        } catch (FileSystemException ex) {
            ex.printStackTrace();
            System.out.println("По указанному пути находится только директория");
            System.exit(1);
        }
        // fail Inp/Out
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Ошибка ввода/вывода файла: " + ex.getMessage());
            System.exit(1);
        }

    }
}
