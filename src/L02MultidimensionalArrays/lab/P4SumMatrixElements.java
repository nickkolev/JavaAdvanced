package L02MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P4SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(scanner, rows, cols);

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            int[] arr = matrix[row];
            for (int el : arr) {
                sum += el;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
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
}
