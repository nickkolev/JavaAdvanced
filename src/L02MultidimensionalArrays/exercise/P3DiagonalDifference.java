package L02MultidimensionalArrays.exercise;

        import java.util.Arrays;
        import java.util.Scanner;

public class P3DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, n);

        int mainSum = mainDiagonalSum(matrix);
        int secondarySum = secondaryDiagonalSum(matrix);

        int result = Math.abs(mainSum - secondarySum);
        System.out.println(result);
    }

    private static int[][] readMatrix(Scanner scanner, int n) {

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static int mainDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }

    private static int secondaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == matrix[row].length - col - 1) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }
}
