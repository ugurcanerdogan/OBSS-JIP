package OccurencesOfWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileOperations {
    public static String fileReader(String fileName) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));

        return data.toLowerCase();
    }

    public static List<String> textSplitter(String solidText) {
        return Arrays.asList(solidText
                .replaceAll("[^a-zA-Z ]", "")
                .toLowerCase()
                .split("\\s+"));

        // If we want to keep punctuation -> return Arrays.asList(solidText.split("\\s+"));
    }
}
