package src.RegularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String [] input = scanner.nextLine().split("\\|");

         String regexFirsPart ="([#$%*&-])(?<first>[A-Z]{1,})\\1";
        Pattern patternFirst = Pattern.compile(regexFirsPart);
        Matcher matcherFirst = patternFirst.matcher(input[0]);

        String regexSecondPart ="(?<ASCIICode>[0-9]+)[:](?<lenght>[0-9]{1,20})";
        Pattern patternSecond = Pattern.compile(regexSecondPart);
        Matcher matcherSecond = patternSecond.matcher(input[1]);

        String regexThirdPart ="";
        Pattern patternThird = Pattern.compile(regexThirdPart);
        Matcher matcherThird = patternThird.matcher(input[2]);
    }
}
