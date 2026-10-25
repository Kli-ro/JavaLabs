package Lab7.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class GetLinesStreamFail {
    public Stream<String> getLinesStream(String path) throws IOException {
        return Files.lines(Path.of(path));
    }
}
