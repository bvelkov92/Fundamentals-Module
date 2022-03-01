package src.AssociativeArraysMoreExercisec;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numDragons = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, String>> typeAndNameAndForces = new LinkedHashMap<>();

        for (int i = 0; i < numDragons; i++) {
            String[] dragonLine = scanner.nextLine().split(" ");
            String dragonType = dragonLine[0];
            String dragonName = dragonLine[1];
            String defaultHealth = "250";
            String defaultDamage = "45";
            String defaultArmor = "10";
            String dragonDamage;
            String dragonHealth;
            String dragonArmor;

            String currentDamage = dragonLine[2];
            if (currentDamage.equals("null")) {
                dragonDamage = defaultDamage;
            } else {
                dragonDamage = dragonLine[2];
            }
            String currentHealth = dragonLine[3];
            if (currentHealth.equals("null")) {
                dragonHealth = defaultHealth;
            } else {
                dragonHealth = dragonLine[3];
            }
            String currentArmor = dragonLine[4];
            if (currentArmor.equals("null")) {
                dragonArmor = defaultArmor;
            } else {
                dragonArmor = dragonLine[4];
            }

            String force = dragonDamage + " " + dragonHealth + " " + dragonArmor;

            if (typeAndNameAndForces.containsKey(dragonType)) {
                if (!typeAndNameAndForces.get(dragonType).containsValue(dragonName)) {
                    typeAndNameAndForces.get(dragonType).put(dragonName, force);

                } else if (typeAndNameAndForces.get(dragonType).containsValue(dragonName)) {
                    typeAndNameAndForces.get(dragonType).put(dragonName, force);
                }
            } else {
                Map<String, String> currentInMap = new HashMap<>();
                currentInMap.put(dragonName, force);
                typeAndNameAndForces.put(dragonType, currentInMap);
            }
        }
        typeAndNameAndForces.entrySet().stream().forEach(currentType -> {
            Map<String,String> newMap = new LinkedHashMap<>();
            currentType.getValue().entrySet().stream().sorted((dragon1, dragon2) -> dragon1.getKey().compareTo(dragon2.getKey()))
                    .forEach(currentDrag -> {
                        newMap.put(currentDrag.getKey(), currentDrag.getValue());
                    });
            List<Integer> damage = new ArrayList<>();
            List<Integer> health = new ArrayList<>();
            List<Integer> armor = new ArrayList<>();
            newMap.entrySet().forEach(item ->{
                                String[] forceArr = item.getValue().split(" ");
                            int currentDamage = Integer.parseInt(forceArr[0]);
                            int currentHealth = Integer.parseInt(forceArr[1]);
                            int currentArmor = Integer.parseInt(forceArr[2]);
                damage.add(currentDamage);
                health.add(currentHealth);
                armor.add(currentArmor);
        });
            double avgDamage=0;
            double avgHealth=0;
            double avgArmor=0;
            for (int i = 0; i < damage.size(); i++) {
                avgDamage+=damage.get(i);
                avgHealth+=health.get(i);
                avgArmor+=armor.get(i);
            }
            avgDamage/=damage.size();
            avgHealth/=health.size();
            avgArmor/=armor.size();
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n",currentType.getKey(), avgDamage, avgHealth, avgArmor);

                    newMap.entrySet().forEach(dragon-> {
                        String name = dragon.getKey();
                        String[] forceArr = dragon.getValue().split(" ");
                        int currentDamage = Integer.parseInt(forceArr[0]);
                        int currentHealth = Integer.parseInt(forceArr[1]);
                        int currentArmor = Integer.parseInt(forceArr[2]);
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                                ,name,currentDamage,currentHealth,currentArmor);
                    });
             });
    }
}
