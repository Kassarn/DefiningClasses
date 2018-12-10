package p06_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        Map<String,Trainer> trainers = new LinkedHashMap<>( );


        while (!"Tournament".equals(line = reader.readLine())) {
            List<Pokemon> pokemons = new ArrayList<>();
            String[] tokens = line.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemons.add(pokemon);
            Trainer trainer = new Trainer(trainerName, pokemons);
            if(!trainers.containsKey(trainerName)){
                trainers.put(trainerName,trainer);
            } else {
                trainers.get(trainerName).addPokemon(pokemon);
            }
        }


        while (!"End".equals(line = reader.readLine())) {

            for (Trainer trainer : trainers.values()) {
                boolean hasElement = false;
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if(pokemon.getElement().equals(line)) {
                        hasElement = true;
                    }
                }
                if(hasElement){
                    trainer.addBadge();
                } else {
                    for (Pokemon pokemon1 : trainer.getPokemons()) {
                        pokemon1.looseHealth();
                    }
                }
                removePokemons(trainers);
            }
        }

        trainers.values().stream().
                 sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);

    }

    private static void removePokemons(Map<String, Trainer> trainers) {
        for (Trainer trainer : trainers.values()) {
            trainer.getPokemons().removeIf(pokemon -> pokemon.getHealth()<=0);
        }
    }
}
