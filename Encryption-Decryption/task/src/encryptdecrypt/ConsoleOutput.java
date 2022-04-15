package encryptdecrypt;

public class ConsoleOutput implements OutputSourceStrategy {
    @Override
    public void output(String[] result, String filename) {
        for (String message : result) {
            System.out.println(message);
        }
    }
}