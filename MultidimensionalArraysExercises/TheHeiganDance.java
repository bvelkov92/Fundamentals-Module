package src.MultidimensionalArraysExercises;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dmgDownHeigan = Double.parseDouble(scanner.nextLine());
        double startDMGOfHeigan = 3000000;
        double startPlayerDMG = 18500;

        int value = 1;
        int[][] mattrixOfPlayer = readMatrix(value);

        int[] playerPosition = new int[2];
        playerPosition[0]=7;
        playerPosition[1]=7;
        String prevousSpell = "";
        String[] input = scanner.nextLine().split("\\s+");
        int cloudCounter =0;
        while (startPlayerDMG > 0 || startDMGOfHeigan > 0) {
            int row = playerPosition[0];
            int col = playerPosition[1];
            startDMGOfHeigan -= dmgDownHeigan;
            if (startDMGOfHeigan <= 0) {
                break;
            }

            String spell = input[0];
            int dmgForCloud = 3500;
            int dmgForEruption = 6000;
            int takedDMG;
            if (spell.equals("Cloud")) {
                takedDMG = dmgForCloud;
                cloudCounter=1;
            } else {
                takedDMG = dmgForEruption;
            }

            int spellRow = Integer.parseInt(input[1]);
            int spellCol = Integer.parseInt(input[2]);

            int upBorder = upBorder(spellRow, 1);
            int downBorder = downBorder(mattrixOfPlayer, spellRow, 1);
            int leftBorder = leftBorder(1, spellCol);
            int rightBorder = rightBorder(mattrixOfPlayer, spellRow, 1, spellCol);

            boolean needToMove = false;

            boolean checkRow = false;
            boolean checkCol = false;
            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];
            for (int rows = upBorder; rows <=downBorder; rows++) {
                for (int cols =leftBorder ; cols <=rightBorder ; cols++) {
                    if (playerRow==rows && playerCol==cols){
                        needToMove=true;
                    }
                }
                if(needToMove){
                    break;
                }
            }
            boolean canMove=false;
                if (needToMove){
                    canMove = movePlayer(playerPosition, spellRow, spellCol, mattrixOfPlayer, row, col);
                }
                if(!canMove && needToMove){
                        if (prevousSpell.equals("Cloud") && cloudCounter > 0) {
                            takedDMG += 3500;
                            cloudCounter--;
                        }
                        startPlayerDMG -= takedDMG;
                    }

            mattrixOfPlayer[upBorder][spellCol] = 0;
            mattrixOfPlayer[downBorder][spellCol] = 0;
            mattrixOfPlayer[spellRow][leftBorder] = 0;
            mattrixOfPlayer[spellRow][rightBorder] = 0;
            mattrixOfPlayer[spellRow][spellCol] = 0;
            mattrixOfPlayer[upBorder][leftBorder] = 0;
            mattrixOfPlayer[upBorder][rightBorder] = 0;
            mattrixOfPlayer[downBorder][leftBorder] = 0;
            mattrixOfPlayer[downBorder][rightBorder] = 0;

            prevousSpell=spell;

           input = scanner.nextLine().split("\\s+");
        }
    }
    
    public static int[][] readMatrix(int value) {
            int rows = 15;
            int cols = 15;
        int[][] matrix = new int[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                        matrix[row][col]= value;
                }
            }
            return matrix;
        }

    public static int upBorder(int currentRow, int currentRadius) {
        int upBorder;

        if (currentRow - currentRadius < 0) {
            upBorder = 0;
        } else {
            upBorder = currentRow - currentRadius;
        }
        return upBorder;
    }

    public static int downBorder(int[][] matrix, int currentRow, int currentRadius) {
        int downBorder;
        if (currentRow + currentRadius > matrix.length-1) {
            downBorder = matrix.length-1;
        } else {
            downBorder = currentRow + currentRadius;
        }
        return downBorder;
    }

    public static int rightBorder(int[][] matrix, int currentRow, int currentRadius, int currentCol) {
        int rightBorder;
        if (currentCol + currentRadius >= matrix[(int) currentRow].length) {
            rightBorder = matrix[(int) currentRow].length-1;
        } else {
            rightBorder = currentCol + currentRadius;
        }
        return rightBorder;
    }

    public static int leftBorder(int currentRadius, int currentCol) {
        int leftBorder;
        if (currentCol - currentRadius <= 0) {
            leftBorder = 0;
        } else {
            leftBorder = currentCol - currentRadius;
        }
        return leftBorder;
    }

    public static boolean movePlayer(int[] playerPosition, int row, int col, int [][] playerMatrix, int currentRow, int currentCol){
        if (playerMatrix[row-1][col]==1){
            playerPosition[0]=currentRow-1;
            playerPosition[1]=currentCol;
            return true;
        }else if(playerMatrix[row][col+1]==1){
            playerPosition[0]=currentRow;
            playerPosition[1]=currentCol+1;
            return true;
        }else if (playerMatrix[row+1][col]==1){
            playerPosition[0]=currentRow+1;
            playerPosition[1]=currentCol;
            return true;
        }else if(playerMatrix[row][col-1]==1){
            playerPosition[0]=currentRow;
            playerPosition[1]=currentCol-1;
            return true;
        }
        return false;
    }
}
