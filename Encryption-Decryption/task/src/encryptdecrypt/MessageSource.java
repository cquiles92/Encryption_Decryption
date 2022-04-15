package encryptdecrypt;

public class MessageSource implements InputSourceStrategy {
    @Override
    public String[] read(String inputSource) {
        return new String[]{inputSource};
    }
}
