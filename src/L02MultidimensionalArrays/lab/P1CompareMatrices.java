package L02MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P1CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEquals = compareTwoMatrices(firstMatrix, secondMatrix);

        String output = areEquals ? "equal" : "not equal";
        System.out.println(output);
    }

    private static int[][] readMatrix(Scanner scanner) {

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt) //.mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            matrix[row] = arr;
        }
        /*
        for (int row = 0; row < matrix.length; row++) {
            String[] data = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(data[col]);
            }
        }
         */

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
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

    private static boolean compareTwoMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        //check if the matrices have equal dimensions
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstMatrixArr = firstMatrix[row];
            int[] secondMatrixArr = secondMatrix[row];

            //check if the rows has the same length
            if(firstMatrixArr.length != secondMatrixArr.length) {
                return false;
            }

            for (int col = 0; col < firstMatrixArr.length; col++) {
                int firstMatrixElement = firstMatrixArr[col];
                int secondMatrixElement = secondMatrixArr[col];

                //check if the elements are the same
                if(firstMatrixElement != secondMatrixElement) {
                    return false;
                }
            }
        }
        return true;
    }
}
