package src.MultidimensionalArraysExercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String [] input = scanner.nextLine().split(", ");
         int rows =Integer.parseInt(input[0]);
         String selectedMatrix = input[1];

         int [][] matrixA = readMatrixA(rows);
         int [][] matrixB = readMatrixB(rows);

        if (selectedMatrix.equals("A")){
                    printMatrix(matrixA,rows);
        }else {
            printMatrix(matrixB,rows);
        }
    }

    public static void printMatrix (int [][] matrix, int rows){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] +" ");
            }
            System.out.println();
        }
    }

   public static int[][] readMatrixA(int rows) {
        int value =1;
        //int cols = 0;
        int currentRows = 0;

           int[][] matrix = new int[rows][rows];
       for (int col = 0; col < rows; col++) {
               while (currentRows<rows){
                   matrix[currentRows][col]=value;
                   value++;
                   currentRows++;
               }
               currentRows=0;
           }
           return matrix;
       }

    private static int[][] readMatrixB(int rows) {
    int value =1;
    int currentRows = 0;

    int[][] matrix = new int[rows][rows];
       for (int col = 0; col < rows; col++) {
           if (col%2==0) {
               while (currentRows < rows) {
                   matrix[currentRows][col] = value;
                   value++;
                   currentRows++;
               }
           }else{
               currentRows--;
               while (currentRows >= 0) {
                   matrix[currentRows][col] = value;
                   value++;
                   currentRows--;
               }
               currentRows++;
           }
    }
           return matrix;
}
}
