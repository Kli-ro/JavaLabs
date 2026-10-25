package Lab7.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LazyLines {
    public static void main(String[] args) throws IOException {
        try(Stream<String> stream = Files.lines(Path.of("course.txt"))) {

            stream.forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println("Ошибка файла: " + ex.getMessage());
        }

    }
}
