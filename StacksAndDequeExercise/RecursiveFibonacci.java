package src.StacksAndDequeExercise;

import java.util.Scanner;

public class RecursiveFibonacci {

    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fibonachiNumber = scanner.nextInt();
        memory = new long[fibonachiNumber+1];
        System.out.println(fib(fibonachiNumber));
    }

    public static long fib (int n){
        if (n<=1){
            return 1;
        }
        if (memory[n]!=0){
            return memory[n];
        }
        return fib(n-1)+fib(n-2);
    }
}
