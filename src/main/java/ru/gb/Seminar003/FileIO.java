package ru.gb.Seminar003;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

    private final File file;
    public FileIO(String fileName) {
        this.file = new File(fileName + ".txt");
    }

    public void save(String userInput) throws IOException{
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.isFile()){
                fileWriter.append(userInput);
            }
            else {
                fileWriter.write(userInput);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
