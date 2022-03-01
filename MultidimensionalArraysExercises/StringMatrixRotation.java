package src.MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandToRotation = scanner.nextLine();
        int rotation = rotation(commandToRotation);

        String input = scanner.nextLine();
        List<String> wordList = new ArrayList<>();
        while (!input.equals("END")) {
            wordList.add(input);
            input = scanner.nextLine();
        }
        int rows = wordList.size();

        char[][] charMatrix = readMatrix(rows, wordList);

        if (rotation > 360) {
            rotation %= 360;
        }
        printResult(charMatrix,rotation);
    }
    public static char[][] readMatrix(int rows, List<String> wordList) {
            char [][] matrix = new char[rows][];
            for (int row = 0; row < rows; row++) {
                matrix[row] = wordList.get(row).toCharArray();
            }
            return matrix;
        }

        public static int rotation (String command){
            StringBuilder rotationCommand =new StringBuilder();

            for (int i = 0; i < command.length(); i++) {
                char currentSymbol = command.charAt(i);
                if(Character.isDigit(currentSymbol)){
                    rotationCommand.append(currentSymbol);
                }
            }
            int rotate = Integer.parseInt(rotationCommand.toString());
            return rotate;
        }
        public static int maxLongWordCharNumbers(char[][] matrix){
        int currentMax=0;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row].length>currentMax){
                    currentMax = matrix[row].length;
                }
            }
            return currentMax;
        }

        public static void printResult(char[][] charMatrix, int rotation){
        int rows;
            switch (rotation) {
                case 0:
                    for (int row = 0; row < charMatrix.length; row++) {
                        for (int col = 0; col < charMatrix[row].length; col++) {
                            System.out.print(charMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                case 90: {
                    int cols = 0;
                    int maxCol = maxLongWordCharNumbers(charMatrix);
                    rows = charMatrix.length;
                    while (maxCol > cols) {
                        for (int row = rows; row > 0; row--) {
                            if (charMatrix[row - 1].length <= cols) {
                                System.out.print(" ");
                            } else {
                                System.out.print(charMatrix[row - 1][cols]);
                            }
                        }
                        System.out.println();
                        cols++;
                    }
                }
                break;
                case 180:
                    for (int row = charMatrix.length - 1; row >= 0; row--) {
                        for (int col = charMatrix[row].length - 1; col >= 0; col--) {
                            System.out.print(charMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                case 270: {
                    int maxCol = maxLongWordCharNumbers(charMatrix);
                    maxCol -= 1;

                    while (maxCol >= 0) {
                        for (int row = 0; row <charMatrix.length; row++) {
                            if (charMatrix[row].length-1 < maxCol) {
                                System.out.print(" ");
                            } else {
                                System.out.print(charMatrix[row][maxCol]);
                            }
                        }
                        System.out.println();
                        maxCol--;

                    }
                    break;
                }
                case 360: {
                    for (int row = 0; row < charMatrix.length; row++) {
                        for (int col = 0; col < charMatrix[row].length; col++) {
                            System.out.print(charMatrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                }
            }
        }
}
