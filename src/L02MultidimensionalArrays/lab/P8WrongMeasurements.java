package L02MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P8WrongMeasurements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, rows);

        String[] wrongNumberCoordinates = scanner.nextLine().split(" ");
        int wrongNumber = matrix[Integer.parseInt(wrongNumberCoordinates[0])][Integer.parseInt(wrongNumberCoordinates[1])];

        int[][] resultMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == wrongNumber) {
                    //fix the wrong number
                    int newNumber = 0;
                    if(indexesIsValid(matrix, row - 1, col) && matrix[row - 1][col] != wrongNumber) {
                        newNumber += matrix[row - 1][col];
                    }
                    if(indexesIsValid(matrix, row + 1, col) && matrix[row + 1][col] != wrongNumber) {
                        newNumber += matrix[row + 1][col];
                    }
                    if(indexesIsValid(matrix, row, col - 1) && matrix[row][col - 1] != wrongNumber) {
                        newNumber += matrix[row][col - 1];
                    }
                    if(indexesIsValid(matrix, row, col + 1) && matrix[row][col + 1] != wrongNumber) {
                        newNumber += matrix[row][col + 1];
                    }

                    resultMatrix[row][col] = newNumber;
                } else {
                    resultMatrix[row][col] = matrix[row][col];
                }
            }
        }

        printMatrix(resultMatrix);
    }

    private static boolean indexesIsValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {

        int[][] matrix = new int[rows][rows];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }

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
    }
}
