package src.RegularExpressions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split(", *");
        Arrays.sort(demons);

        String healthReg = "[^\\-0-9\\+\\*\\/\\.]*";
        String baseDamageReg = "[\\-\\+]?([0-9]+)[.]?[0-9]*";
        String symbolsForBaseDamage = "[\\/\\*]";

        StringBuilder sb = new StringBuilder();

        for (String demon : demons) {
            demon = demon.replaceAll(" ", "");
            Pattern pattern = Pattern.compile(healthReg);
            Matcher matcher = pattern.matcher(demon);
            while (matcher.find()) {
                sb.append(matcher.group());
            }

            String healthString = sb.toString();
            sb.setLength(0);
            int health = 0;
            for (int i = 0; i < healthString.length(); i++) {
                health += healthString.charAt(i);
            }

            pattern = Pattern.compile(baseDamageReg);
            matcher = pattern.matcher(demon);
            double damage = 0.0;
            while (matcher.find()) {
                String group = matcher.group();
                String sign = "" + group.charAt(0);
                if (sign.equals("+")) {
                    damage += Double.parseDouble(group.substring(1));
                } else if (sign.equals("-")) {
                    damage -= Double.parseDouble(group.substring(1));
                } else {
                    damage += Double.parseDouble(group);
                }
            }

            pattern = Pattern.compile(symbolsForBaseDamage);
            matcher = pattern.matcher(demon);
            while (matcher.find()) {
                String manipulator = matcher.group();
                if (manipulator.equals("*")) {
                    damage *= 2;
                } else if (manipulator.equals("/")) {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }

    }
}
