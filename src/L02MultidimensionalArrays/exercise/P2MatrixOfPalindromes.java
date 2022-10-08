package L02MultidimensionalArrays.exercise;

import java.util.Scanner;

public class P2MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[][] matrix = new String[r][c];

        generateMatrix(matrix, r, c);
        printMatrix(matrix);
    }

    private static void generateMatrix(String[][] matrix, int r, int c) {

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                String palindrome = "" + (char)(97 + row) + (char)(97 + col + row) + (char)(97 + row);
                matrix[row][col] = palindrome;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = matrix[row];
            for (int col = 0; col < arr.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
