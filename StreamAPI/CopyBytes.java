package src.StreamAPI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\input.txt";
        String pathOut = "C:\\Users\\vylch\\IdeaProjects\\ModuleFundamentals\\src\\StreamAPI\\03.CopyBytesOutput.txt";

        FileInputStream input = new FileInputStream(pathIn);
        FileOutputStream output = new FileOutputStream(pathOut);

        int byteOut = input.read();
        while (byteOut >= 0) {

            if (byteOut == 32 || byteOut == 10) {
                output.write(byteOut);
            } else {
                String symbol = String.valueOf(byteOut);
                for (int index = 0; index < symbol.length(); index++) {
                    output.write(symbol.charAt(index));
                }
            }
            byteOut = input.read();
        }
    }
}
