package src.RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex ="(?<day>\\d{2})([\\/.-])(?<month>[A-Z][a-z{3}]+)\\2(?<year>\\d{4})";

        String date = scanner.nextLine();

        Pattern patern = Pattern.compile(regex);
        Matcher matcher = patern.matcher(date);


        while (matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",
                    matcher.group("day"),
                    matcher.group("month"),
                    matcher.group("year"));
        }

    }
}
