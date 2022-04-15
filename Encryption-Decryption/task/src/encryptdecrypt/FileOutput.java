package encryptdecrypt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements OutputSourceStrategy {
    @Override
    public void output(String[] result, String filename) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (String line : result) {
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
