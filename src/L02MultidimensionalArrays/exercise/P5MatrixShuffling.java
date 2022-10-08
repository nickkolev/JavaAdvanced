package L02MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P5MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] params = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(params[0]);
        int cols = Integer.parseInt(params[1]);

        String[][] matrix = readMatrix(scanner, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] input = command.split(" ");

            if (input.length != 5 || !input[0].equals("swap")) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(input[1]);
            int col1 = Integer.parseInt(input[2]);
            int row2 = Integer.parseInt(input[3]);
            int col2 = Integer.parseInt(input[4]);

            if (!indexIsValid(row1, rows) || !indexIsValid(col1, cols) ||
                    !indexIsValid(row2, rows) || !indexIsValid(col2, cols)) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            String tmp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = tmp;

            printMatrix(matrix);

            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean indexIsValid(int i, int max) {
        return i >= 0 && i < max;
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[row] = arr;
        }

        return matrix;
    }
}
