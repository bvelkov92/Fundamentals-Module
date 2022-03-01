package src.SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Set<String> parkingList = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String [] currentArr = input.split(",\\s+");
            String commannd = currentArr[0];
            String carNumber = currentArr[1];

            if (commannd.equals("IN")){

                parkingList.add(carNumber);
            }else {
                    parkingList.remove(carNumber);
            }
            input= scanner.nextLine();
        }

        if (parkingList.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            parkingList.forEach(System.out::println);
        }
    }
}
