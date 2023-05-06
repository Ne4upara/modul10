package ua.goit.sergey.modul10;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toMap;

public class Task3 {

    private final File file;
    private Map<String, Integer> wordToCount;

    public Task3 (String file){
        this(new File(file));
    }

    public Task3 (File file){
        this.file = file;
    }

    public void searchWord() {
        read();
        sortedWord();
        for (Object sor : wordToCount.keySet()) {
            System.out.println(sor + " " + wordToCount.get(sor));
        }
    }

    private void read() {
        wordToCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String words = (br.readLine());

            while (words != null) {
                String[] arrs = words.split("\\s+");
                for (String arr : arrs) {
                    if (!wordToCount.containsKey(arr)) {
                        wordToCount.put(arr, 0);
                    }
                    wordToCount.put(arr, wordToCount.get(arr) + 1);
                }
                words = br.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void sortedWord() {
        Map<String, Integer> sorted = wordToCount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        wordToCount = sorted;
    }
}