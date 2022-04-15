package encryptdecrypt;

public final class Context {
    private static EncryptionStrategy encryptionStrategy;
    private static InputSourceStrategy inputSourceStrategy;
    private static OutputSourceStrategy outputSourceStrategy;
    private static Context context = null;

    Context() {
    }

    public static Context getInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public void setEncryptionStrategy(EncryptionStrategy encryptionStrategy) {
        Context.encryptionStrategy = encryptionStrategy;
    }

    public void setInputSourceStrategy(InputSourceStrategy inputSourceStrategy) {
        Context.inputSourceStrategy = inputSourceStrategy;
    }

    public void setOutputSourceStrategy(OutputSourceStrategy outputSourceStrategy) {
        Context.outputSourceStrategy = outputSourceStrategy;
    }


    public static void execute(Command command) {
        String inputSource = command.getInput();
        String outputSource = command.getOutput();
        int key = command.getKey();
        boolean mode = command.isMode();

        String[] output;

        output = mode ? encryptionStrategy.encode(inputSourceStrategy.read(inputSource), key)
                : encryptionStrategy.decode(inputSourceStrategy.read(inputSource), key);

        outputSourceStrategy.output(output, outputSource);
    }
}
