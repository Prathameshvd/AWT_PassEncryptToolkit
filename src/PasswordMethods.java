package src;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class PasswordMethods {
    public String getEncryptedPassword(String Input, String Key) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, createKey(Key));
        byte[] encryptedBytes = cipher.doFinal(Input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String getDecryptedPassword(String EncryptedPassword, String Key) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, createKey(Key));
        byte[] decodedBytes = Base64.getDecoder().decode(EncryptedPassword);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    private static SecretKey createKey(String keyString) throws IllegalArgumentException {
        // Ensure the keyString is exactly 16 bytes (128 bits) for AES
        if (keyString.length() != 16) {
            throw new IllegalArgumentException("Key must be exactly 16 characters long.");
        }
        byte[] keyBytes = keyString.getBytes();
        return new SecretKeySpec(keyBytes, "AES");
    }
}