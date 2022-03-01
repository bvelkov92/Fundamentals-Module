package src.StacksAndDeques;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            ArrayDeque<String> history = new ArrayDeque<>();
            ArrayDeque <String> forwardHistory = new ArrayDeque<>();
            String input = scanner.nextLine();
            while (!input.equalsIgnoreCase("Home")) {
                if (input.equalsIgnoreCase("back")) {
                    if (history.isEmpty() || history.size()==1) {
                        System.out.println("no previous URLs");
                    } else {
                        String currenNext = history.pollLast();
                        forwardHistory.offerFirst(currenNext);
                        System.out.println(history.peekLast());
                    }
                }else if (input.equalsIgnoreCase("forward")){
                    if (forwardHistory.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        String currentSite =forwardHistory.poll();
                        System.out.println(currentSite);
                        history.offer(currentSite);
                    }
                }else {
                    history.offer(input);
                    System.out.println(input);
                    forwardHistory.clear();
                }
                input= scanner.nextLine();
            }
        }
    }

