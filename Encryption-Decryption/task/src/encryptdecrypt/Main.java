package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Command command = new Command(args);

        Context.execute(command);
    }
}
