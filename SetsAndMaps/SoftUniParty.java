package src.SetsAndMaps;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Set<String>invitedGuests = new LinkedHashSet<>();
        Set<String> comesList = new LinkedHashSet<>();


        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            invitedGuests.add(input);
            input= scanner.nextLine();
        }
        input= scanner.nextLine();
        while (!input.equals("END")) {
                comesList.add(input);
                invitedGuests.remove(input);
            input = scanner.nextLine();
        }
        int  numberGuests= invitedGuests.size();
        System.out.println(numberGuests);
        Set<String> sortedList = new TreeSet<>(invitedGuests);
        sortedList.forEach(System.out::println);
        }
        }

