package src.StreamAPIExercises;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathToWordToContains = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\words.txt";
        List<String> wordsFilePatch =Files.readAllLines(Path.of(pathToWordToContains));

        String pathToText = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\text.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\Answers\\ansWordCount";

        Scanner scanner = new Scanner(new FileInputStream(pathToText));

        Map<String, Integer> containsMap = new HashMap<>();
        Deque<String> wordsQue = new ArrayDeque<>();

        for (String filePatch : wordsFilePatch) {
            String[] currentRow = filePatch.split("\\s+");
            for (String s : currentRow) {
                containsMap.put(s, 0);
                wordsQue.offer(s);
            }
        }

        PrintWriter output = new PrintWriter(pathOut);
        String text = scanner.next();

        if (scanner.hasNext()) {
            while (scanner.hasNext()) {
                containCounter(wordsQue, text, containsMap);
                text = scanner.next();
            }


        }else {
            containCounter(wordsQue, text, containsMap);
        }
        for (String word : wordsQue) {
            Integer numberWords = containsMap.get(word);
            output.printf("%s - %d%n", word, numberWords);
        }
        output.close();
    }

    private static void containCounter(Deque<String> wordsQue, String text, Map<String, Integer> contains) {

        String currentText =text.toLowerCase();

         if ((contains.containsKey(text)|| contains.containsKey(currentText))
                 && (wordsQue.contains(text) || wordsQue.contains(currentText)))
            contains.put(text, contains.get(text) + 1);
    }
}

