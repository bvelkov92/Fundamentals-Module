package src.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int[][] matrixFirst = readMatrix(rows, scanner);
        rows = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        int [][] matrixSecond= readMatrix(rows, scanner);

        boolean entry = isEquals(matrixFirst, matrixSecond);
        System.out.println(entry ? "equal" : "not equal");

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

    public static boolean isEquals(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if (firstArr.length != secondArr.length) {
                return false;
            }
                for (int index = 0; index < firstArr.length; index++) {
                if (firstArr[index] != secondArr[index]) {
                    return false;
                }
            }

        }
        return true;
    }
}
