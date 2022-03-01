package src.StreamAPI;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) throws FileNotFoundException {

        Path pathIn = Paths.get("C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI");

        File file =new File
                        ("C:\\Users\\vylch\\IdeaProjects" +
                                "\\ModuleFundamentals\\src\\StreamAPI\\Files-and-Streams");
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File value : files) {
                    if (!value.isDirectory()) {
                        System.out.printf("%s: [%s]%n", value.getName(), value.length());
                    }
                }
            }
        }
    }
}