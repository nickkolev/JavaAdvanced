package ZExamPreparaton.E25June2022;

import java.util.*;

public class P1ItsChocolateTime {

    //declare our cocoa percentage table
    public static final int MILK_CHOCOLATE = 30;
    public static final int DARK_CHOCOLATE = 50;
    public static final int BAKING_CHOCOLATE = 100;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //read the input
        double[] milkValues = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double[] cacaoValues = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        //the chocolates we have made
        Map<String, Integer> chocolates = new HashMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        //first mil value -> Queue
        Deque<Double> milkValuesQueue = new ArrayDeque<>();
        for (double v : milkValues) {
            milkValuesQueue.offer(v);
        }

        //last cacao value -> stack
        Deque<Double> cacaoValuesStack = new ArrayDeque<>();
        for (double v : cacaoValues) {
            cacaoValuesStack.push(v);
        }

        //make chocolates while we have milk and cocoa
        while (!milkValuesQueue.isEmpty() && !cacaoValuesStack.isEmpty()) {
            double currentMilkValue = milkValuesQueue.peek();
            double currentCacao = cacaoValuesStack.peek();
            double cacaoPercentage = currentCacao / (currentMilkValue + currentCacao) * 100;

            if (cacaoPercentage == MILK_CHOCOLATE) {
                int currentNumOfMilkChocolates = chocolates.get("Milk Chocolate");
                chocolates.put("Milk Chocolate", currentNumOfMilkChocolates + 1);
                milkValuesQueue.poll();
                cacaoValuesStack.pop();
            } else if (cacaoPercentage == DARK_CHOCOLATE) {
                int currentNumOfDarkChocolates = chocolates.get("Dark Chocolate");
                chocolates.put("Dark Chocolate", currentNumOfDarkChocolates + 1);
                milkValuesQueue.poll();
                cacaoValuesStack.pop();
            } else if (cacaoPercentage == BAKING_CHOCOLATE) {
                int currentNumOfBakingChocolates = chocolates.get("Baking Chocolate");
                chocolates.put("Baking Chocolate", currentNumOfBakingChocolates + 1);
                milkValuesQueue.poll();
                cacaoValuesStack.pop();
            } else {
                cacaoValuesStack.pop();
                currentMilkValue += 10;
                milkValuesQueue.poll();
                milkValuesQueue.offer(currentMilkValue);
            }
        }

        boolean isChocolateEmpty = false;
        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
                isChocolateEmpty = true;
                break;
            }
        }

        if (!isChocolateEmpty) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }

        chocolates.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(c -> {
                            if (c.getValue() > 0) {
                                System.out.printf("# %s --> %d%n", c.getKey(), c.getValue());
                            }
                        }
                );
    }
}
