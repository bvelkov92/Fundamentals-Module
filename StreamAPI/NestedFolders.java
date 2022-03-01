package src.StreamAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class NestedFolders {
    public static void main(String[] args) throws FileNotFoundException {
         Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\Files-and-Streams");
        File root = path.toFile();
        Deque<File> que = new ArrayDeque<>();
        int counter =1;
                que.offer(root);
        System.out.println(que.peek().getName());
                while (!que.isEmpty()) {
                    File file = que.poll();
                    File[] files = file.listFiles();
                    for (File current : files) {
                        if (current.isDirectory()) {
                            System.out.println(current.getName());
                            que.offer(current);
                            counter++;
                        }
                    }
            }
        System.out.printf("%d folders", counter);
        }
    }

