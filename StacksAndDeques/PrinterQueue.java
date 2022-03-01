package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Scanner;


public class PrinterQueue {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> list = new ArrayDeque<>();

         String input = scanner.nextLine();
         while (!input.equals("print")){
            if (input.equals("cancel")) {
                if (list.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String lastPrint = list.poll();
                    System.out.println("Canceled "+lastPrint);
                }
            }else {
                list.offer(input);
            }
          input = scanner.nextLine();
         }
         list.forEach(name-> System.out.println(name));
    }
}
