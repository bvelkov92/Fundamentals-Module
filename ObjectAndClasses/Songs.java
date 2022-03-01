package src.ObjectAndClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs {

    static class Song {
        String typeList;
        String name;
        String time;

        public String getName() {
            return name;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int numberSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 0; i <numberSongs ; i++) {

            List<String> data = Arrays.stream(scanner.nextLine().split("_")).collect(Collectors.toList());
           Song currentSong = new Song();

            String typeList = data.get(0);
            String name = data.get(1);
            String time = data.get(2);


            currentSong.setTypeList(typeList);
            currentSong.setName(name);
            currentSong.setTime(time);
            songList.add(currentSong);
        }
        String command = scanner.nextLine();

        if (command.equals("all")){
        for (Song item : songList) {
            System.out.println(item.getName());
        }
        }else {
            for (Song item: songList) {
                if (item.typeList.equals(command)){
                    System.out.println(item.getName());
                }
            }
        }
    }
}
