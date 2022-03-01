package src.StreamAPI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String pathIn = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\input.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\02.WriteToFileOutput.txt";

        FileInputStream input = new FileInputStream(pathIn);
        FileOutputStream output = new FileOutputStream(pathOut);

        int read = input.read();
        Set<Character> restrictedCharacters = Set.of(',', '.', '!', '?');
        while (read>=0){
            if (!restrictedCharacters.contains((char) read )){
                //output.write(read);
                output.write(read);
            }

            read= input.read();
        }
    }
}
