package L02MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P3IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = readMatrix(scanner, rows, cols);
        String[][] secondMatrix = readMatrix(scanner, rows, cols);

        String[][] resultMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = "*";
                }
            }
        }

        printMatrix(resultMatrix);
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            String[] arr = matrix[row];
            for (int col = 0; col < arr.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        /*
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
         */
    }
}
