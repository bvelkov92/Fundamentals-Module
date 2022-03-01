package src.RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexName = "[A-Za-z]";
        Pattern patternName = Pattern.compile(regexName);
        String regexDistance = "[0-9]";
        Pattern patternDistance = Pattern.compile(regexDistance);


        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> nameList = new LinkedHashMap<>();
        names.forEach(name -> nameList.put(name, 0));

        String encryptedText = scanner.nextLine();

        while (!encryptedText.equals("end of race")) {

            Matcher matcherName = patternName.matcher(encryptedText);
            Matcher matcherDistance = patternDistance.matcher(encryptedText);
            int distance = 0;
            StringBuilder currentName = new StringBuilder();
            while (matcherName.find()){
                currentName.append(matcherName.group());
            }
            while (matcherDistance.find()) {
                distance += Integer.parseInt(matcherDistance.group());
            }
            if (nameList.containsKey(currentName.toString())) {
                nameList.put(currentName.toString(), nameList.get(currentName.toString())+distance);
            }
            encryptedText = scanner.nextLine();
        }

        List<String> finalList = new ArrayList<>();
        nameList.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(item ->
                finalList.add(item.getKey()));

        System.out.println("1st place: " + finalList.get(0));
        System.out.println("2nd place: " +finalList.get(1));
        System.out.println("3rd place: " +finalList.get(2));
    }
}
