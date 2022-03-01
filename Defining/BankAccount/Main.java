package src.Defining.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <Integer, BankAccount> peopleList = new HashMap<>();
        String insert = scanner.nextLine();

        while (!insert.equals("End")) {

            String command = insert.split("\\s+")[0];
            BankAccount bankAccount;
            String result = "-";
            switch (command) {
                case "Create":
                    bankAccount = new BankAccount();
                    peopleList.put(bankAccount.getId(), bankAccount);
                    result = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(insert.split("\\s+")[1]);
                    double money = Double.parseDouble(insert.split("\\s+")[2]);
                    if (peopleList.containsKey(id)) {
                        BankAccount bankAccountFromMap = peopleList.get(id);
                        bankAccountFromMap.deposit(money);
                        peopleList.put(id, bankAccountFromMap);
                        result = String.format("Deposited %.0f to ID%d", money, id);
                    } else {
                        result = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(insert.split("\\s+")[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;

                case "GetInterest":
                    int accountID = Integer.parseInt(insert.split("\\s+")[1]);
                    int years = Integer.parseInt(insert.split("\\s+")[2]);
                    if (peopleList.containsKey(accountID)) {
                        BankAccount bankAccount1 = peopleList.get(accountID);
                        double total = bankAccount1.getInterest(years);
                        result = String.format("%.2f", total);
                    } else {
                        result = "Account does not exist";
                    }
                    break;
            }
            if (!result.equals("-")) {
                System.out.println(result);
            }
            insert = scanner.nextLine();
        }
    }
}
