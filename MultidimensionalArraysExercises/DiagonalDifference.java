package src.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int rows = Integer.parseInt(scanner.nextLine());
         int [][] matrix = readMatrix(rows,scanner);
         int firstSum = firstDiagonalSum(matrix,rows);
         int secondSum = secondDiagonalSum(matrix,rows);
         int result = firstSum-secondSum;
        System.out.println(Math.abs(result));

    }

    private static int secondDiagonalSum(int[][] matrix, int rows) {
        int sum=0;
        int col = matrix[0].length-1;
        for (int row = 0; row <rows ; row++) {
            sum+= matrix[row][col];
            col--;
        }
        return sum;
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

        public static int firstDiagonalSum(int[][] matrix,int rows){
        int sum=0;
        int col = 0;
            for (int row = 0; row <rows ; row++) {
                sum+= matrix[row][col];
                col++;
                }
        return sum;
        }


}
