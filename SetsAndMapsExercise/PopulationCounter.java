package src.SetsAndMapsExercise;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> populationCounter = new LinkedHashMap<>();
        Map<String, Long> totalPopulation = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String city = input.split("\\|")[0].trim();
            String country = input.split("\\|")[1].trim();
            Long population = Long.parseLong(input.split("\\|")[2].trim());
            if (!populationCounter.containsKey(country)) {
                Map<String, Long> currentCityAndPopulation = new HashMap<>();
                currentCityAndPopulation.put(city, population);
                populationCounter.put(country, currentCityAndPopulation);
                totalPopulation.put(country, population);
            } else {
                populationCounter.get(country).put(city, population);
                totalPopulation.put(country, totalPopulation.get(country) + population);
            }
            input = scanner.nextLine();
        }

        totalPopulation
                .entrySet()
                .stream()
                .sorted((count1, count2)->
                    count2.getValue().compareTo(count1.getValue()))
                .forEach(country -> {
            System.out.printf("%s (total population: %d)%n",country.getKey(),country.getValue());

            populationCounter.get(country.getKey()).entrySet().stream().sorted((population1, population2) ->
                           population2.getValue().compareTo(population1.getValue()))
            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
        });
    }
}
