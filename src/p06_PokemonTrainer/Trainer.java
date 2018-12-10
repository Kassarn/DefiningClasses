package p06_PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name,List<Pokemon> pokemons) {
            this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addBadge () {
        this.numberOfBadges+=1;
    }
    public void addPokemon(Pokemon pokemon){
        this.getPokemons().add(pokemon);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    @Override
    public String toString() {
       return String.format("%s %s %s",this.name,this.numberOfBadges,this.pokemons.size());
    }
}
