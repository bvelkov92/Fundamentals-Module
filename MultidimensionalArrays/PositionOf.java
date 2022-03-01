package src.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);


         int [][] matrix = readMatrix(rows,scanner);
         int searchNumber = Integer.parseInt(scanner.nextLine());
        boolean notEquals=false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                if (matrix[row][col]== searchNumber){
                    System.out.println(row +" " +col);
                    notEquals=true;
                }
            }
        }
        if (!notEquals){
            System.out.println("not found");
        }

    }
    public static int[][] readMatrix(int rows, Scanner scanner) {
            int[][] matrix = new int[rows][];
            for (int row = 0; row < rows; row++) {
                matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            return matrix;
        }
}
