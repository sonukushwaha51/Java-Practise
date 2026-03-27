package fileOperations;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriterDemo {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("src/fileOperations/Hello.txt")) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (IOException exception) {
            //
        }

        // Copy to another file, append
        try (FileReader reader = new FileReader("src/fileOperations/Hello.txt")) {
            try (FileWriter writer = new FileWriter("src/fileOperations/Hello-Copy.txt", true)) {
                int ch;
                while ((ch  = reader.read()) != -1) {
                    writer.write((char) ch);
                }
            } catch (IOException exception) {
                //
            }
        } catch (IOException exception) {
            //
        }

        // Copy to same file
        String stringToAppend = "Good Bye";
        try (FileWriter writer = new FileWriter("src/fileOperations/Hello.txt", true)) {
            writer.write(stringToAppend);
        } catch (IOException exception) {
            //
        }

    }
}
