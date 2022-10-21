package L06DefiningClasses.exercise.P6PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Tournament")) {
            String[] tokens = command.split(" ");
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}

            String trainerName = tokens[0];
            Trainer trainer;

            if(trainers.containsKey(trainerName)) {
                trainer = trainers.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }

            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainer.getPokemons().add(pokemon);
            trainers.put(trainerName, trainer);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equals("End")) {
            String element = command;
            //"Fire", "Water", "Electricity"

            for (Trainer trainer : trainers.values()) {
                boolean isFound = trainer
                        .getPokemons()
                        .stream()
                        .anyMatch(pokemon -> pokemon.getElement().equals(element));

                if(isFound) {
                    int newBadges = trainer.getBadges() + 1;
                    trainer.setBadges(newBadges);
                } else {
                    trainer.getPokemons()
                            .forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    trainer.setPokemons(trainer.getPokemons()
                            .stream()
                            .filter(pokemon -> pokemon.getHealth() > 0)
                            .collect(Collectors.toList()));
                }
            }
            command = scanner.nextLine();
        }
        Comparator<Trainer> compareByBadges = Comparator
                .comparing(Trainer::getBadges)
                .reversed();

        trainers.values().stream()
                .sorted(compareByBadges)
                .forEach(System.out::println);
    }
}
