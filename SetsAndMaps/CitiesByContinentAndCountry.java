package src.SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,List<String>>>continentAndCountry=new LinkedHashMap<>();

        int numInputs = Integer.parseInt(scanner.nextLine());
        while (numInputs>0){
            String [] inputArr = scanner.nextLine().split("\\s+");
            String continent = inputArr[0];
            String country = inputArr[1];
            String city = inputArr[2];
            if (!continentAndCountry.containsKey(continent)){

                Map<String,List<String>> currentCountryAndCity = new LinkedHashMap<>();
                List<String> currentCity = new ArrayList<>();
                currentCity.add(city);
                currentCountryAndCity.put(country,currentCity);
                continentAndCountry.put(continent, currentCountryAndCity);
            }else {
                if (continentAndCountry.containsKey(continent) && !continentAndCountry.get(continent).containsKey(country)){
                    List<String> curCity = new ArrayList<>();
                    curCity.add(city);
                    continentAndCountry.get(continent).put(country,curCity);
                }else {
                    continentAndCountry.get(continent).get(country).add(city);
                }
            }
            numInputs--;
        }

        System.out.println();
        continentAndCountry.entrySet().forEach(continent ->{
            System.out.printf("%s:%n",continent.getKey());
            continent.getValue().entrySet().forEach(country->{
                System.out.printf("%s -> ",country.getKey());
                System.out.println(String.join(", ", country.getValue()));
            });
        });
    }
}
