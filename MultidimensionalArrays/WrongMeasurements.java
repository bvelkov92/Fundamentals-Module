package src.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int rows = Integer.parseInt(scanner.nextLine());
         int[][]  matrix = readMatrix(rows,scanner);
         int cols = matrix[0].length;
         int [] coordinates =Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
         int value = matrix[coordinates[0]][coordinates[1]];

         int[][] trueMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col]==value){
                    int leftSide=0;
                    int rightSide=0;
                    int upSide=0;
                    int downSide=0;
                    if (row< matrix.length-1 && matrix[row+1][col] !=value){
                        downSide = matrix[row+1][col];
                    }
                    if (row>0 && matrix[row-1][col] !=value){
                        upSide=matrix[row-1][col];
                    }
                    if (col>0 && matrix[row][col-1] !=value){
                        leftSide= matrix[row][col-1];
                    }
                    if (col<matrix[row].length-1 && matrix[row][col+1] !=value){
                        rightSide = matrix[row][col+1];
                    }
                    trueMatrix[row][col]= downSide+upSide+rightSide+leftSide;
                }else {
                    trueMatrix[row][col]= matrix[row][col];
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < trueMatrix[row].length; col++) {
                System.out.print(trueMatrix[row][col] + " ");
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
