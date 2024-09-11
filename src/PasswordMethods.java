package src;

public final class PasswordMethods {
    String getEncryptedPassword(String Input, String Key) {
        return Input + Key;
    }
}