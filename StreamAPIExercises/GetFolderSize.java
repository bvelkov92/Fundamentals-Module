package src.StreamAPIExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) throws FileNotFoundException {

        Path path =Paths.get
                ("C:\\Users\\vylch\\Desktop\\rosources\\Java\\Exercises Resources");
        String outputPatch = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPIExercises\\Answers\\ansGetFolderSize.txt";
        PrintWriter output = new PrintWriter(outputPatch);
        int directorySumSize =0;
        File [] file =path.toFile().listFiles();
        for (File current:file){
                directorySumSize+=current.length();
            }
        output.printf("Folder size: %d",directorySumSize);
        output.close();

    }
}
