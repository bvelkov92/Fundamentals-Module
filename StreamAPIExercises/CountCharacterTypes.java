package src.StreamAPIExercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\input.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\Answers\\ansCountCharacterTypes";
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');
        PrintWriter output = new PrintWriter(pathOut);
        int vowelsCounter = 0;
        int punctuationCounter = 0;
        int others = 0;
        List<String> listIn = Files.readAllLines(Path.of(pathIn));
        for (String currentRow : listIn) {
            char[] currentRowFromList = currentRow.toCharArray();
            for (char element : currentRowFromList) {
                if (vowels.contains(element)) {
                    vowelsCounter++;
                } else if (punctuation.contains(element)) {
                    punctuationCounter++;
                } else if (element != 32) {
                    others++;
                }
            }
        }
        output.printf("Vowels: %d%n",vowelsCounter);
        output.printf("Consonants: %d%n", others);
        output.printf("Punctuation: %d%n",punctuationCounter);
        output.close();
    }
}