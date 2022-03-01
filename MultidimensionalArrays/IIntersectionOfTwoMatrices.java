package src.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IIntersectionOfTwoMatrices {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int rows = Integer.parseInt(scanner.nextLine());
         int cols = Integer.parseInt(scanner.nextLine());

         String [][] matrix = readMatrix(rows,scanner);
        String [][] matrixTwo = readMatrix(rows,scanner);
        String [][] outMatrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals(matrixTwo[row][col])){
                    outMatrix[row][col]=matrix[row][col];
                }else {
                    outMatrix[row][col]="*";
                }
            }
        }


        for (int row = 0; row < outMatrix.length; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(outMatrix[row][col] +" ");
            }
            System.out.println();
        }
    }
    public static String[][] readMatrix(int rows, Scanner scanner) {
            String [][] matrix = new String[rows][];
            for (int row = 0; row < rows; row++) {
                matrix[row] = scanner.nextLine().split("\\s+");
            }
            return matrix;
        }
}
