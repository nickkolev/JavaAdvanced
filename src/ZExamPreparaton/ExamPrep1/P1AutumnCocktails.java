package ZExamPreparaton.ExamPrep1;

import java.util.*;

public class P1AutumnCocktails {

    private static final int PEAR_SOUR = 150;
    private static final int THE_HARVEST = 250;
    private static final int APPLE_HINNY = 300;
    private static final int HIGH_FASHION = 400;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        //Четем съставки в опашка
        String[] tokens = scanner.nextLine().split(" ");
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (String token : tokens) {
            ingredients.offer(Integer.parseInt(token));
        }

        //Четем освежители в стак
        tokens = scanner.nextLine().split(" ");
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        for (String token : tokens) {
            freshness.push(Integer.parseInt(token));
        }


        while(!ingredients.isEmpty() && !freshness.isEmpty()) {

            int firstIngredient = ingredients.poll();
            if(firstIngredient == 0 ) {
                continue;
            }

            int lastFreshener = freshness.pop();

            int freshnessLevel = firstIngredient * lastFreshener;
            if (freshnessLevel == PEAR_SOUR) {
                int currentNumber = cocktails.get("Pear Sour");
                currentNumber++;
                cocktails.put("Pear Sour", currentNumber);
            } else if (freshnessLevel == THE_HARVEST) {
                int currentNumber = cocktails.get("The Harvest");
                currentNumber++;
                cocktails.put("The Harvest", currentNumber);
            } else if (freshnessLevel == APPLE_HINNY) {
                int currentNumber = cocktails.get("Apple Hinny");
                currentNumber++;
                cocktails.put("Apple Hinny", currentNumber);
            } else if (freshnessLevel == HIGH_FASHION) {
                int currentNumber = cocktails.get("High Fashion");
                currentNumber++;
                cocktails.put("High Fashion", currentNumber);
            } else {
                firstIngredient += 5;
                ingredients.offer(firstIngredient);
            }
        }

        if(cocktails.get("Pear Sour") > 0 &&
                cocktails.get("The Harvest") > 0 &&
                cocktails.get("Apple Hinny") > 0 &&
                cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(!ingredients.isEmpty()) {
            int leftoverIngredients = ingredients.stream().mapToInt(e -> e).sum();
            System.out.printf("Ingredients left: %d%n", leftoverIngredients);
        }

        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            //# {cocktail name} --> {amount}
            if(entry.getValue() > 0) {
                System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
