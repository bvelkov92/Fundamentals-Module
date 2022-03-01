package src.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String [] input = scanner.nextLine().split(", ");
         int rows = Integer.parseInt(input[0]);
         int cols = Integer.parseInt(input[1]);
         int sum =0;

        int[][] matrix = readMatrix(rows,scanner);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum +=matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    public static int[][] readMatrix(int rows, Scanner scanner) {
            int[][] matrix = new int[rows][];
            for (int row = 0; row < rows; row++) {
                matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            return matrix;
        }
}
