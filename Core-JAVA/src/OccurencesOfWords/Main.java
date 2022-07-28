package OccurencesOfWords;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        String pathName = "C:\\Users\\uqi\\Desktop\\OBSS-JIP\\OccurencesOfWords\\news.txt";
        try {
            String text = FileOperations.fileReader(pathName);
            List<String> words = FileOperations.textSplitter(text);
            TreeMap<String, Integer> wordMap = WordCounter.listToCountMap(words);
            WordCounter.displayOccurences(wordMap);

        } catch (IOException e) {
            System.out.println("File couldn't opened..!");
        } finally {
            System.out.println("The program is terminating.");
        }
    }
}
