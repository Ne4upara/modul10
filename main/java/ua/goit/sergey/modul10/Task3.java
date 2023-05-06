package ua.goit.sergey.modul10;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toMap;

public class Task3 {

    private final File file;

    public Task3 (String file){
        this(new File(file));
    }

    public Task3 (File file){
        this.file = file;
    }

    public void searchWord() throws IOException {
        File file = new File("./src/main/resources/text3.txt");
        Map<String, Integer> wordToCount = new HashMap<>();

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

        Map<String, Integer> sorted = wordToCount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        for (String sor : sorted.keySet()) {
            System.out.println(sor + " " + sorted.get(sor));
        }
    }
}