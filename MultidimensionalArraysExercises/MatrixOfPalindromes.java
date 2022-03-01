package src.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int [] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String [][] matrix = readMatrix(rows,cols);
        printMatrix(matrix,rows,cols);

    }
    public static String [][] readMatrix(int rows,int cols) {
            String[][] matrix = new String[rows][cols];
        int startSymbol = 97;
        char rowSymbol = (char)(startSymbol-1);
        char colSymbol;
            for (int row = 0; row < rows; row++) {
                rowSymbol++;
                colSymbol=(char) (startSymbol+row);
                for (int col = 0; col < cols; col++) {
                    StringBuilder currentStr = new StringBuilder();
                    currentStr.append(rowSymbol).append(colSymbol).append(rowSymbol);
                    matrix[row][col] = currentStr.toString();
                    colSymbol++;
                }
            }
            return matrix;
        }
        public static void printMatrix(String [][] matrix, int rows, int cols){
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        }
}
