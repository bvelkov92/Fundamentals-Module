package src.MultidimensionalArraysExercises;

import java.util.Scanner;


public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);


        String[][] matrix = readMatrix(rows, cols);


        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] inputArr = input.split("\\s+");
            String[][] currenMatrix = new String[matrix.length][cols];


            int currentRow = Integer.parseInt(inputArr[0]);
            int currentCol = Integer.parseInt(inputArr[1]);
            int currentRadius = Integer.parseInt(inputArr[2]);
            borders(matrix, currentRow, currentCol, currentRadius);
            int startIndexRow = 0;
            int startIndexCol = 0;
            for (String[] strings : matrix) {
                for (String string : strings) {

                    if (string == null) {
                        break;
                    }
                    if (!string.equals(" ")) {
                        currenMatrix[startIndexRow][startIndexCol] = string;
                        startIndexCol++;
                    }
                }
                startIndexRow++;
                startIndexCol = 0;
            }
            matrix = currenMatrix;
            input = scanner.nextLine();
        }
        for (String[] strings : matrix) {
            if (strings[0] == null) {
                continue;
            }
            for (String string : strings) {
                if (string == null) {
                    break;
                }
                System.out.print(string + " ");
            }
            System.out.println();
        }


    }
    public static String[][] readMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        int start = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String number = start+"";
                matrix[row][col]=number.trim();
                start++;
            }
        }
        return matrix;
    }

    public static String[][] borders(String[][] matrix, int row, int col, int radius) {
        int upBorder = Math.max(0,row-radius);
        int downBorder = Math.min(matrix.length-1,row+radius);


        for (int i = upBorder; i <=downBorder ; i++) {
            if (i>=0 && i<= matrix.length-1 && col>=0 && col <matrix[i].length){
                matrix[i][col] = " ";
            }
        }
        if (row>=0 && row<= matrix.length-1){
            int leftBorder = Math.max(0,col-radius);
            int rightBorder = Math.min(matrix[row].length-1,col+radius);
            for (int i = row; i <=row ; i++) {
                for (int cols = leftBorder; cols <= rightBorder; cols++) {
                    matrix[row][cols]=" ";
                }
            }
        }
        return matrix;
    }
}