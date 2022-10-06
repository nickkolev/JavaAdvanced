package L02MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P6PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, rows);

        int[] mainDiagonal = new int[rows];
        int[] secondaryDiagonal = new int[rows];

        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int col = 0; col < rows; col++) {
            System.out.print(matrix[rows - 1 - col][col] + " ");
        }
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
}
