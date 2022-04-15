package encryptdecrypt;

import java.util.ArrayList;

public class EncryptCaesar implements EncryptionStrategy {
    @Override
    public String[] encode(String[] originalMessage, int key) {
        ArrayList<String> returnResult = new ArrayList<>();
        StringBuilder returnMessage = new StringBuilder();

        for (String message : originalMessage) {
            int i = 0;
            while (i < message.length()) {
                char currentChar = message.charAt(i++);
                if (!Character.isLetter(currentChar)) {
                    returnMessage.append(currentChar);
                } else {
                    if (Character.isLowerCase(currentChar)) {
                        returnMessage.append(encryptCharacter(key, currentChar, 'a'));
                    } else {
                        returnMessage.append(encryptCharacter(key, currentChar, 'A'));
                    }
                }
            }
            returnResult.add(returnMessage.toString());
            returnMessage.setLength(0);
        }

        return returnResult.toArray(new String[0]);
    }

    @Override
    public String[] decode(String[] originalMessage, int key) {
        key = 26 - (key % 26);

        return encode(originalMessage, key);
    }

    private char encryptCharacter(int key, char originalCharacter, char selectedCase) {
        int originalPosition = originalCharacter - selectedCase;
        int newPosition = (originalPosition + key) % 26;
        return (char) (selectedCase + newPosition);
    }
}