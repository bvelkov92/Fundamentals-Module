package src.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vat= n->n*1.20;
        Consumer<Double> upgradedWithVat = n-> System.out.printf("%.2f%n", n);

        String [] inputLine = scanner.nextLine().split(", ");
        System.out.println("Prices with VAT:");
        List<Double> finalList = Arrays.stream(inputLine)
                .map(Double::parseDouble).collect(Collectors.toList());
        finalList.stream().map(vat).forEach(upgradedWithVat);
    }
}
