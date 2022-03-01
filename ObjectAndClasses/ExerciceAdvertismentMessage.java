package src.ObjectAndClasses;

import java.util.Random;
import java.util.Scanner;

public class ExerciceAdvertismentMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCircles = Integer.parseInt(scanner.nextLine());

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product."
                , "Best product of its category.", "Exceptional product.", "I can’t live without this product."};

        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};


        for (int i = 0; i < numberCircles; i++) {

            Random randomPhrase = new Random();
            Random randomEvents = new Random();
            Random randomAutors = new Random();
            Random randomCities = new Random();

            int currentPhrase = -1;
            for (int p = 0; p < phrases.length; p++) {
                int index = randomPhrase.nextInt(phrases.length);
                currentPhrase = index;
            }

            int currentEvent = -1;
            for (int e = 0; e < events.length; e++) {
                int index = randomEvents.nextInt(events.length);
                currentEvent = index;
            }

            int currentAuthor = -1;
            for (int a = 0; a < authors.length; a++) {
                int index = randomAutors.nextInt(authors.length);
                currentAuthor = index;
            }
            int currentCity = -1;
            for (int c = 0; c < cities.length; c++) {
                int index = randomCities.nextInt(cities.length);
                currentCity = index;
            }
            System.out.printf("%s %s %s-%s%n", phrases[currentPhrase], events[currentEvent], authors[currentAuthor], cities[currentCity]);
        }

    }
}
