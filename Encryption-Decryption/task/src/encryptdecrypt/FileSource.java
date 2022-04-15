package encryptdecrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileSource implements InputSourceStrategy {

    @Override
    public String[] read(String filename) {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                result.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toArray(new String[0]);
    }
}
