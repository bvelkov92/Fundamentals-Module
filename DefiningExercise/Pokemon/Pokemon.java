package src.DefiningExercise.Pokemon;

public class Pokemon {

    private String pokemonName;
    private String pokemonElement;
    private int pokemonHealht;

    public int setPokemonHealht() {
       return this.pokemonHealht = pokemonHealht-10;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonElement() {
        return pokemonElement;
    }

    public int getPokemonHealht() {
        return pokemonHealht;
    }



    public Pokemon(String pokemonName, String pokemonElement, int pokemonHealht) {
        this.pokemonName = pokemonName;
        this.pokemonElement = pokemonElement;
        this.pokemonHealht = pokemonHealht;
    }

}
