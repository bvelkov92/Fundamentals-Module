package src.SetsAndMaps;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> shopList = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")){
            String [] inputArr = input.split(",\\s+");
            String shopName = inputArr[0];
            String productAndPrice = inputArr[1]+" "+inputArr[2];
            if (!shopList.containsKey(shopName)){
                List<String> currentList = new ArrayList<>();
                currentList.add(productAndPrice);
                shopList.put(shopName,currentList);
            }else {
                shopList.get(shopName).add(productAndPrice);
            }
            input= scanner.nextLine();
        }
        shopList.entrySet().stream().forEach(shop->{
            System.out.printf("%s-> %n",shop.getKey());
            for (int index = 0; index < shop.getValue().size(); index++) {
                String [] currentValue = shop.getValue().get(index).split("\\s+");
                System.out.printf("Product: %s, Price: %.1f%n", currentValue[0],Double.parseDouble(currentValue[1]));
            }
        });

    }
}
