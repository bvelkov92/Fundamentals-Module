package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (browserHistory.size()<=1) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else {
                System.out.println(input);
                browserHistory.push(input);
            }

            input= scanner.nextLine();
        }
    }
}
