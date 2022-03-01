package src.MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 8;
        String[][] matrix = readMatrix(rows, scanner);
        boolean stop = false;
        int rowIndex =-1;
        int colIndex = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("q")) {
                    boolean isValidHorAndVer = isValidVeriticalAndHorizontal(matrix, row, col);
                    if (isValidHorAndVer){
                        stop=true;
                        rowIndex =row;
                        colIndex = col;
                    }
                    break;
                }
            }
            if(stop){
                break;
            }
        }
        int finalRow=rowIndex;
        int finalCol = colIndex;
        System.out.println(finalRow + " " + finalCol);
    }
    public static String[][] readMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static boolean isValidVeriticalAndHorizontal(String[][] matrix, int rows, int cols) {
        int currentRow = rows+1;
                           int currentCol = cols+1;
        for (int row = rows; row <= rows; row++) {
            for (int col = currentCol; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("q")) {
                    return false;
                }
            }
        }
        for (int nextRow = currentRow; nextRow < matrix.length; nextRow++) {
                        if (matrix[nextRow][cols].equals("q")) {
                            return false;
                        }
                    }
        int whileCols = cols+1;
        int whileRows=rows+1;
        int downRows = rows-1;
        int downCols = cols-1;
        int lastCheckRow =rows+1;
        int lastCheckCol= cols-1;
        while (downRows >=0 && downCols>=0){
           if (matrix[downRows][downCols].equals("q")){
               return false;
           }
            downRows--;
            downCols--;
        }

        while (whileRows<matrix.length && whileCols<matrix[whileRows].length){
            if (matrix[whileRows][whileCols].equals("q")){
                return false;
            }
            whileRows++;
            whileCols++;
        }
        while (lastCheckRow< matrix.length && lastCheckCol>=0){
            if (matrix[lastCheckRow][lastCheckCol].equals("q")){
                return false;
            }
            lastCheckRow++;
            lastCheckCol--;
        }
        return true;
    }
}
