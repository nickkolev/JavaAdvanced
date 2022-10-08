package L02MultidimensionalArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P7Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        int count = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }

        String command = scanner.nextLine();
        while(!command.equals("Nuke it from orbit")) {
            String[] bombParams = command.split(" ");

            int row = Integer.parseInt(bombParams[0]);
            int col = Integer.parseInt(bombParams[1]);
            int radius = Integer.parseInt(bombParams[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)){
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            
            command = scanner.nextLine();
        }

        for(List<Integer> integers : matrix){
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
