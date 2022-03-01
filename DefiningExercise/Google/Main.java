package src.DefiningExercise.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Map<String,Person> personData = new HashMap<>();


         String inputLine = scanner.nextLine();

         while (!inputLine.equals("End")){

             String[] inputArr  = inputLine.split("\\s+");
             String name = inputArr[0];
             String className = inputArr[1];
             if (!personData.containsKey(name)){

                 personData.put(name, new Person());
             }

             switch (className){

                 case "company":
                     String companyName =inputArr[2];
                     String department=inputArr[3];
                     double salary=Double.parseDouble(inputArr[4]);
                     Company company = new Company(companyName,department,salary);
                     personData.get(name).setCompany(company);

                     break;


                 case "pokemon":
                     String pokemonName =inputArr[2];
                     String pokemonType=inputArr[3];
                     Pokemon pokemon = new Pokemon(pokemonName,pokemonType);

                    personData.get(name).getPokemon().add(pokemon);
                     break;

                 case "parents":
                     String parentName =inputArr[2];
                     String parentBirthday=inputArr[3];
                     Parent parent = new Parent(parentName,parentBirthday);
                     personData.get(name).getParents().add(parent);
                     break;


                 case "children":
                     String childName =inputArr[2];
                     String childBirthday=inputArr[3];
                     Children child = new Children(childName,childBirthday);
                     personData.get(name).getChildren().add(child);
                     break;


                 case "car":
                     String carModel=inputArr[2];
                     int carSpeed=Integer.parseInt(inputArr[3]);
                     Car car = new Car(carModel,carSpeed);
                     personData.get(name).setCar(car);
                     break;


             }

             inputLine= scanner.nextLine();
         }

         String searchName = scanner.nextLine();

        System.out.println(searchName);

        Person person = personData.get(searchName);
        System.out.println(person);
    }
}
