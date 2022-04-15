package encryptdecrypt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Argument {
    MODE, KEY, DATA, IN, OUT, ALG;

    @Override
    public String toString() {
        return "-" + this.name().toLowerCase();
    }

}

enum Encryption {
    UNICODE, SHIFT
}

enum InputSource {
    FILE, DATA
}

enum OutputSource {
    FILE, CONSOLE
}

public class Command {
    private int key;
    private boolean mode;
    private String input;
    private String inputFile;
    private String data;
    private String output;
    private String encryptionType;

    Command(String[] args) {
        key = 0;
        mode = true;
        input = "";
        inputFile = "";
        data = "";
        output = "";
        encryptionType = "shift";

        setFields(args);
        setContext();
    }

    private void setFields(String[] args) {
        List<String> fields = new ArrayList<>(Arrays.asList(args));

        if (fields.contains(Argument.KEY.toString())) {
            key = Integer.parseInt(fields.get(fields.indexOf(Argument.KEY.toString()) + 1));
        }

        if (fields.contains(Argument.MODE.toString())) {
            mode = fields.get(fields.indexOf(Argument.MODE.toString()) + 1).equals("enc");
        }

        if (fields.contains(Argument.IN.toString())) {
            inputFile = fields.get(fields.indexOf(Argument.IN.toString()) + 1);
            input = inputFile;
        } else if (fields.contains(Argument.DATA.toString())) {
            data = fields.get(fields.indexOf(Argument.DATA.toString()) + 1);
            input = data;
        }

        if (fields.contains(Argument.OUT.toString())) {
            output = fields.get(fields.indexOf(Argument.OUT.toString()) + 1);
        }

        if (fields.contains(Argument.ALG.toString())) {
            encryptionType = fields.get(fields.indexOf(Argument.ALG.toString()) + 1);
        }
    }

    private void setContext() {
        Context context = Context.getInstance();

        Encryption encryptionSelection = Encryption.valueOf(encryptionType.toUpperCase());
        InputSource inputSource = inputFile.length() > 0 ? InputSource.FILE : InputSource.DATA;
        OutputSource outputSource = output.equals("") ? OutputSource.CONSOLE : OutputSource.FILE;

        switch (encryptionSelection) {
            case SHIFT:
                context.setEncryptionStrategy(new EncryptCaesar());
                break;
            case UNICODE:
                context.setEncryptionStrategy(new EncryptUnicode());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + encryptionSelection);
        }

        switch (inputSource) {
            case FILE:
                context.setInputSourceStrategy(new FileSource());
                break;
            case DATA:
                context.setInputSourceStrategy(new MessageSource());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inputSource);

        }

        switch (outputSource) {
            case FILE:
                context.setOutputSourceStrategy(new FileOutput());
                break;
            case CONSOLE:
                context.setOutputSourceStrategy(new ConsoleOutput());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + outputSource);
        }
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public int getKey() {
        return key;
    }

    public boolean isMode() {
        return mode;
    }
}
