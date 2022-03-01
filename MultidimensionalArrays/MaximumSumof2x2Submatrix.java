package src.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumof2x2Submatrix {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String[] input = scanner.nextLine().split(", ");
         int rows =Integer.parseInt(input[0]);
         int[][] matrix = readMatrix(rows, scanner);
         int maxSum = 0;
         int [][] endMatrix = new int [2][2];

        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int upLeft = matrix[row][col];
                int upRight = matrix[row][col + 1];
                int downLeft = matrix[row + 1][col];
                int downRight = matrix[row + 1][col + 1];
                int currentSum = upLeft + upRight + downLeft + downRight;
                if (currentSum > maxSum) {
                    endMatrix[0][0] = upLeft;
                    endMatrix[0][1] = upRight;
                    endMatrix[1][0] = downLeft;
                    endMatrix[1][1] = downRight;
                    maxSum = currentSum;
                }
            }
        }
            for (int finalRow = 0; finalRow < endMatrix.length; finalRow++) {
                for (int finalCol = 0; finalCol < endMatrix[finalRow].length; finalCol++) {
                    System.out.print(endMatrix[finalRow][finalCol] +" ");
                }
                System.out.println();
            }
            System.out.println(maxSum);
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
