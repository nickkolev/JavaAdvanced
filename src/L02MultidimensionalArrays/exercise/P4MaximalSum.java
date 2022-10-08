package L02MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] matrix = readMatrix(scanner, n, m);

        calculateMaxSum(n, m, matrix);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt) //.mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            matrix[row] = arr;
        }

        return matrix;
    }

    private static void calculateMaxSum(int rows, int cols, int[][] matrix) {

        int maxSum = Integer.MIN_VALUE;
        int startingRow = -1;
        int startingCol = -1;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if(sum > maxSum) {
                    maxSum = sum;
                    startingRow = row;
                    startingCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrix(matrix, startingRow, startingCol);
    }

    private static void printMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 3; row++) {
            int[] arr = matrix[row];
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
