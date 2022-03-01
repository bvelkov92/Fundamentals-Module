package src.ObjectAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExeciceArticles {

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
            this.title=title;
            this.content=content;
            this.author = author;
        }


        @Override
        public String toString() {
            return String.format("%s - %s: %s",this.getTitle(),this.getContent(),this.getAuthor());
        }
    }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String [] startArr = scanner.nextLine().split(", ");
         List<Articles> articlesList = new ArrayList<>();

        int numberChanges = Integer.parseInt(scanner.nextLine());
        String currentTitle = startArr[0];
        String currentContent = startArr[1];
        String currentAuthor = startArr[2];

        for (int i = 1; i <= numberChanges; i++) {

            String[] commandArr = scanner.nextLine().split(": ");
            String command = commandArr[0];
            switch (command) {
                case "Edit":
                {
                    currentContent = commandArr[1];
            break;
        }
                case "ChangeAuthor":
                    currentAuthor =commandArr[1];
                    break;

                case "Rename":
                    currentTitle = commandArr[1];
                    break;
            }

        }
        Articles currentArticle = new Articles(currentTitle,currentContent,currentAuthor);
        articlesList.add(currentArticle);
        for (Articles item: articlesList) {
            System.out.println(item);
        }
    }
}
