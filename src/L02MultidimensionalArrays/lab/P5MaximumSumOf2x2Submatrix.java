package L02MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P5MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(scanner, rows, cols);

        int maxSum = 0;
        int[][] result = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int first = matrix[row][col];
                int second = matrix[row][col + 1];
                int third = matrix[row + 1][col];
                int fourth = matrix[row + 1][col + 1];

                int sum = first + second + third + fourth;
                if(sum > maxSum) {
                    maxSum = sum;
                    result = new int[][] {{matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}};
                }
            }
        }

        printMatrix(result);
        System.out.println(maxSum);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
