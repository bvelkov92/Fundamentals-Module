package src.ObjectAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExerciseArticles2 {

    static class Articles {
        String title;
        String content;
        String author;

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }

        Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }


        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.getTitle(), this.getContent(), this.getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Articles> articlesList = new ArrayList<>();

        int numberChanges = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= numberChanges; i++) {
            String[] startArr = scanner.nextLine().split(", ");

            String currentTitle = startArr[0];
            String currentContent = startArr[1];
            String currentAuthor = startArr[2];

            Articles currentArticle = new Articles(currentTitle, currentContent, currentAuthor);
            articlesList.add(currentArticle);
        }
        String command = scanner.nextLine();
        switch (command) {
            case "title" -> sortTitle(articlesList);
            case "content" -> sortContent(articlesList);
            case "author" -> sortAuthor(articlesList);
        }

    }

    private static void sortTitle(List<Articles> notSortedList) {
        List<Articles> sortedList = notSortedList.stream()
                .sorted(Comparator.comparing(Articles::getTitle))
                .collect(Collectors.toList());
        for (Articles sortedItems : sortedList) {
            System.out.println(sortedItems);
        }
    }

    private static void sortContent(List<Articles> notSortedList) {
        List<Articles> sortedList = notSortedList.stream()
                .sorted(Comparator.comparing(Articles::getContent))
                .collect(Collectors.toList());
        for (Articles sortedItems : sortedList) {
            System.out.println(sortedItems);
        }
    }

    private static void sortAuthor(List<Articles> notSortedList) {
        List<Articles> sortedList = notSortedList.stream()
                .sorted(Comparator.comparing(Articles::getAuthor))
                .collect(Collectors.toList());
        for (Articles sortedItems : sortedList) {
            System.out.println(sortedItems);
        }
    }
}
