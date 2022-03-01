package src.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = input[0];
        int[][] matrix = readMatrix(rows, scanner);

        int maxSum = 0;
        int [][] endMatrix = new int [3][3];

        for (int row = 0; row < matrix.length-2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int upLeft = matrix[row][col];
                int upRight = matrix[row][col + 1];
                int upRightTwo = matrix[row][col + 2];
                int downLeft = matrix[row + 1][col];
                int downRight = matrix[row + 1][col + 1];
                int downRightTwo = matrix[row + 1][col + 2];
                int downCenterThree = matrix[row + 2][col];
                int downRightThree = matrix[row + 2][col + 1];
                int downLeftThree = matrix[row + 2][col + 2];

                int currentSum = upLeft + upRight + downLeft + downRight+upRightTwo+downRightTwo+downCenterThree
                        +downRightThree+downLeftThree;
                if (currentSum > maxSum) {
                    endMatrix[0][0] = upLeft;
                    endMatrix[0][1] = upRight;
                    endMatrix[0][2] = upRightTwo;
                    endMatrix[1][0] = downLeft;
                    endMatrix[1][1] = downRight;
                    endMatrix[1][2] = downRightTwo;
                    endMatrix[2][0] =downCenterThree;
                    endMatrix[2][1]=downRightThree;
                    endMatrix[2][2]=downLeftThree;
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("Sum = " +maxSum);
        for (int finalRow = 0; finalRow < endMatrix.length; finalRow++) {
            for (int finalCol = 0; finalCol < endMatrix[finalRow].length; finalCol++) {
                System.out.print(endMatrix[finalRow][finalCol] +" ");
            }
            System.out.println();
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

