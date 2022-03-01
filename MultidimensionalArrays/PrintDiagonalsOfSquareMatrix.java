package src.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String[] input =scanner.nextLine().split("\\s+");
         int rows = Integer.parseInt(input[0]);

         int [][] matrix = readMatrix(rows,scanner);
         int cols = 0;
         int row = 0;
         while (row< rows){
                 System.out.print(matrix[row][cols] +" ");
                 row++;
                 cols++;
         }
        System.out.println();
         cols=0;
        while (rows>0){
            System.out.print(matrix[rows-1][cols] +" ");
            rows--;
            cols++;
        }
        System.out.println();
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
