package src.RegularExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberLines = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldierCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < numberLines; i++) {
            String encryptedMessayge = scanner.nextLine();
            String deCryptedMessage = DecryptedMessage(encryptedMessayge);

            Matcher matcherDecrypted = pattern.matcher(deCryptedMessage);
            if (matcherDecrypted.find()) {
                String namePlanet = matcherDecrypted.group("planetName");
                String attType = matcherDecrypted.group("attackType");
                if (attType.equals("A")) {
                    attackedPlanets.add(namePlanet);
                } else if (attType.equals("D")) {
                    destroyedPlanets.add(namePlanet);
                }
            }
        }
            System.out.println("Attacked planets: " + attackedPlanets.size());
        Collections.sort(attackedPlanets);
            attackedPlanets.forEach(item ->
                    System.out.println("-> " + item));
            System.out.println("Destroyed planets: " + destroyedPlanets.size());
            Collections.sort(destroyedPlanets);
            destroyedPlanets.forEach(item ->
                    System.out.println("-> " + item));


    }
    public static String DecryptedMessage(String encryptedMessage) {
        StringBuilder newMessage = new StringBuilder();
        int counter = 0;
        String text = encryptedMessage.toLowerCase();
        for (int i = 0; i < text.toCharArray().length; i++) {
            if (text.charAt(i) == 's' || text.charAt(i) == 't' || text.charAt(i) == 'a'
                    || text.charAt(i) == 'r') {
                counter++;
            }
        }
            if (counter > 0) {
                for (int newSymbols = 0; newSymbols < encryptedMessage.length(); newSymbols++) {
                    char currentSymbol = encryptedMessage.charAt(newSymbols);
                    char decryptedSymbol = (char) (currentSymbol - counter);
                    newMessage.append(decryptedSymbol);
                }
                return newMessage.toString();
            }
       return encryptedMessage;
    }
}
