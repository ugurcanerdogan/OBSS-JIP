package OccurencesOfWords;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WordCounter {

    public static TreeMap<String, Integer> listToCountMap(List<String> listOfWords) {
        Map<String, Integer> countMap = listOfWords
                .stream()
                .collect(Collectors.toMap(element -> element, element -> 1, Integer::sum));

        return new TreeMap<>(countMap);
    }

    public static void displayOccurences(TreeMap<String, Integer> sortedMap) {
        sortedMap.entrySet().stream().forEach(element -> System.out.println("Word: " + element.getKey() + " --- " + "Frequency: " + element.getValue()));
        // Also applies -> sortedMap.entrySet().forEach(System.out::println);
    }
}
