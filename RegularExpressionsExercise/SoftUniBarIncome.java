package src.RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "%(?<customer>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<counter>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalSum = 0;
        while (!text.equals("end of shift")) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int counter = Integer.parseInt(matcher.group("counter"));
                double price = Double.parseDouble(matcher.group("price"));
                price *= counter;
                System.out.printf("%s: %s - %.2f%n", customer, product, price);
                totalSum += price;
            }
            text = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f%n",totalSum);
    }
}
