package src.AssociativeArraysExercise;


import java.util.*;
import java.util.stream.Collectors;

public class Orders {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<String, Double> keyAndPricePerOne = new LinkedHashMap<>();
        Map<String, Integer> keyAndNumItems = new LinkedHashMap<>();

        while (!text.equals("buy")) {

            List<String> startValues = Arrays.stream(text.split(" ")).collect(Collectors.toList());

                    String key = startValues.get(0);
                    double pricePerOne =Double.parseDouble(startValues.get(1));
                    int numberFromItem =Integer.parseInt(startValues.get(2));

                    if(!keyAndPricePerOne.containsKey(key) && !keyAndNumItems.containsKey(key)){
                        keyAndPricePerOne.put(key,pricePerOne);
                        keyAndNumItems.put(key,numberFromItem);
                    }else{
                        double currentPrice = keyAndPricePerOne.get(key);
                        if(currentPrice!=pricePerOne){
                            keyAndPricePerOne.put(key, pricePerOne);
                        }
                        keyAndNumItems.put(key,keyAndNumItems.get(key)+numberFromItem);
                    }

                    text= scanner.nextLine();
        }

        for (Map.Entry<String, Double> item : keyAndPricePerOne.entrySet()) {
            String currentsum = item.getKey();
            double finalSum = item.getValue()* keyAndNumItems.get(currentsum);
            System.out.printf("%s -> %.2f%n", item.getKey(), finalSum);
        }


    }
}
