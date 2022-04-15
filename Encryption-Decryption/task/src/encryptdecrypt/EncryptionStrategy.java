package encryptdecrypt;

public interface EncryptionStrategy {
    String[] encode(String[] originalMessage, int key);
    String[] decode(String[] originalMessage, int key);
}
