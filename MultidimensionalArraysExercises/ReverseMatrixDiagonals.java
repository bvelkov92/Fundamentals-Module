package src.MultidimensionalArraysExercises;

import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);

        String[][] matrix = readMatrix(rows, scanner);
        int col = Integer.parseInt(input[1]);
        int cols = col;
        if (col > 1) {
            while (cols > 0) {
                int currentCol = cols - 1;
                int currentRow = rows - 1;
                while (currentCol < col && currentRow >= 0) {
                    System.out.print(matrix[currentRow][currentCol] + " ");
                    currentCol++;
                    currentRow--;
                }
                System.out.println();
                cols--;
            }

            int row = matrix.length - 1;
            while (row > 0) {
                int currentRow = row - 1;
                int currentCol = 0;
                while (currentRow >= 0) {
                    if(currentCol>=matrix[currentRow].length){
                        break;
                    }
                    System.out.print(matrix[currentRow][currentCol] + " ");
                    currentCol++;
                    currentRow--;
                }
                System.out.println();

                row--;
            }

        } else {
            for (int index = matrix.length - 1; index >= 0; index--) {
                System.out.println(matrix[index][0] + " ");
            }
        }
    }

    public static String[][] readMatrix(int rows, Scanner scanner) {
            String[][] matrix = new String[rows][];
            for (int row = 0; row < rows; row++) {
                matrix[row] = scanner.nextLine().split("\\s+");
            }
            return matrix;
        }
}
