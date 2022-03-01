package src.DefiningExercise.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;

    public int getNumberBadjes() {
        return numberBadjes;
    }

    private int numberBadjes=0;
     private List< String> pokemonList=new ArrayList<>();


    public String getName() {
        return name;
    }

    public List<String> getPokemonList() {
        return pokemonList;
    }


   public void setNumberBadjes() {
        this.numberBadjes= numberBadjes+1;
   }

    public Trainer(String name, int numberBadjes, List<String> pokemonList) {
        this.name = name;
        this.numberBadjes = numberBadjes;
        this.pokemonList = pokemonList;
    }

   public Trainer(String name, List<String> pokemon) {
      this.name = name;
      this.numberBadjes = 0;
      this.pokemonList = pokemon;
   }
}
