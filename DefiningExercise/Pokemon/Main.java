package src.DefiningExercise.Pokemon;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String startInput = scanner.nextLine();
        Map<String, Pokemon> pokemonList = new LinkedHashMap<>();
        Map<String, Trainer> trainerPokemons = new LinkedHashMap<>();

        while (!startInput.equals("Tournament")) {

            String[] inputArr = startInput.split("\\s+");
            String trainerName = inputArr[0];
            String pokemonName = inputArr[1];
            String pokemonElement = inputArr[2];
            int pokemonHealth = Integer.parseInt(inputArr[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonList.put(pokemonName, pokemon);
            List<String> newPokemonList = new ArrayList<>();
            if (!trainerPokemons.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName, newPokemonList);
                newPokemonList.add(pokemonName);
                trainerPokemons.put(trainerName, trainer);
            } else if (!trainerPokemons.get(trainerName).getPokemonList().contains(pokemonName)) {
                trainerPokemons.get(trainerName).getPokemonList().add(pokemonName);
            }

            startInput = scanner.nextLine();
        }

        String element = scanner.nextLine();
        while (!element.equals("End")) {
            boolean toStop = false;
            String typeElement = element;
            List<String> pokemonsWithThisElement = new ArrayList<>();
            pokemonList.entrySet().forEach(key -> {
                if (key.getValue().getPokemonElement().equals(typeElement)) {
                    pokemonsWithThisElement.add(key.getValue().getPokemonName());
                }
            });

            for (Map.Entry<String, Trainer> trainer : trainerPokemons.entrySet()) {
                boolean havePokemonWithThisElement = false;

                for (String poke : pokemonsWithThisElement) {
                    if (trainer.getValue().getPokemonList().contains(poke)) {
                        havePokemonWithThisElement = true;
                        break;
                    }
                }

                if (havePokemonWithThisElement) {
                    trainer.getValue().setNumberBadjes();
                    toStop = true;
                } else {
                    trainerPokemons.get(trainer.getKey()).getPokemonList().forEach(currentPokemon -> {
                        if (pokemonList.containsKey(currentPokemon)) {
                            if (pokemonList.get(currentPokemon).getPokemonHealht() > 0) {
                                pokemonList.get(currentPokemon).setPokemonHealht();
                            }
                        }
                    });
                }
                if (toStop) {
                    break;
            }
            }
        trainerPokemons.entrySet().forEach((key-> key.getValue().getPokemonList()
                .forEach(pokemon -> {
                    if(pokemonList.containsKey(pokemon)) {
                        if (pokemonList.get(pokemon).getPokemonHealht() <= 0) {
                            pokemonList.remove(pokemon);
                        }
                    }
        })));

            element = scanner.nextLine();
        }

        trainerPokemons.forEach((key, value) -> value.getPokemonList().forEach(pokemon -> {
            if (pokemonList.containsKey(pokemon)) {
                if (pokemonList.get(pokemon).getPokemonHealht() <= 0) {
                    pokemonList.remove(pokemon);
                }
            }
        }));
            trainerPokemons.forEach((key, value) -> {
                for (int i = 0; i < value.getPokemonList().size(); i++) {
                    String pokemon = value.getPokemonList().get(i);
                    if (!pokemonList.containsKey(pokemon)) {
                        value.getPokemonList().remove(pokemon);
                        i = -1;
                    }
                }
            });


        Map<String, Integer> finalMap = new LinkedHashMap<>();
        trainerPokemons.forEach((key, value) -> finalMap.putIfAbsent(key, value.getNumberBadjes()));

        finalMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(el -> {
            System.out.printf("%s %d %d%n"
                    , el.getKey(), el.getValue(), trainerPokemons.get(el.getKey()).getPokemonList().size());  //name, badges, pokemons
        });
    }
}


