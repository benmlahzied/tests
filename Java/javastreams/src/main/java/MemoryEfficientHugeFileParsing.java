import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemoryEfficientHugeFileParsing {

    public static void main(String... args) {
        Path filePath = Paths.get(
                Paths.get(".").toAbsolutePath().getParent().toString(),
                "src/main/resources/textFile");
        try {
            Stream<String> lines = Files.lines(filePath);
            Function<String, Stream<String>> splitToWords =
                    line -> Pattern.compile(" ").splitAsStream(line);
            Stream<String> words = lines.flatMap(splitToWords);
            Map<Integer, Long> wordsGroupedByLength = words
                    .filter(word -> word.length() > 2 )
                    .collect(
                            Collectors.groupingBy(
                               String::length,
                               Collectors.counting()
                            ));
            wordsGroupedByLength.forEach(
                    (key,value) -> System.out.println(
                            String.format("%s words having %s characters", value,key)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}