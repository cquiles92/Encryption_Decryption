package encryptdecrypt;

import java.util.ArrayList;

public class EncryptUnicode implements EncryptionStrategy {
    @Override
    public String[] encode(String[] originalMessage, int key) {
        ArrayList<String> returnResult = new ArrayList<>();
        StringBuilder returnMessage = new StringBuilder();

        for (String message : originalMessage) {
            int i = 0;
            while (i < message.length()) {
                char currentChar = message.charAt(i++);
                returnMessage.append(encryptCharacter(currentChar, key));
            }
            returnResult.add(returnMessage.toString());
            returnMessage.setLength(0);
        }

        return returnResult.toArray(new String[0]);
    }

    private char encryptCharacter(char originalCharacter, int key) {
        return (char) ((int) originalCharacter + key);
    }

    @Override
    public String[] decode(String[] originalMessage, int key) {
        return encode(originalMessage, -key);
    }

    private char decryptCharacter(char character, int key) {
        return (char) ((int) character - key);
    }
}
