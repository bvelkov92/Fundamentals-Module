package src.MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        String[][] matrix = readMatrix(rows, scanner);
        String inputLine = scanner.nextLine();


        while (!inputLine.equals("END")) {
            String[] swap = inputLine.split("\\s+");
            boolean isValid = isValid(matrix, swap);

            if (!isValid) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(swap[1]);
                int col1 = Integer.parseInt(swap[2]);
                int row2 = Integer.parseInt(swap[3]);
                int col2 = Integer.parseInt(swap[4]);
                String replacement = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = replacement;
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            }
            inputLine = scanner.nextLine();
        }
    }

    public static String[][] readMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static boolean isValid(String[][] matrix, String[] command) {
        if (command[0].equals("swap") && command.length==5) {
            int row1 = Integer.parseInt(command[1]);
            int col1 = Integer.parseInt(command[2]);
            int row2 = Integer.parseInt(command[3]);
            int col2 = Integer.parseInt(command[4]);
                return row1 < matrix.length
                        && row1 >= 0
                        && row2 < matrix.length
                        && row2 >= 0
                        && col1 < matrix[0].length
                        && col1 >= 0
                        && col2 < matrix[0].length
                        && col2 >= 0;
            }
        return false;
    }
}
