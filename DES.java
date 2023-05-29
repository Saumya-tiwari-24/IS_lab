import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DES {
    public static void main(String[] args) {
        try {
            // Generate a DES key from a string
            String keyString = "SecretKey";
            SecretKey secretKey = generateDESKey(keyString);

            // Encrypt plaintext
            String plaintext = "Hello, DES!";
            String ciphertext = encrypt(plaintext, secretKey);

            // Decrypt ciphertext
            String decryptedText = decrypt(ciphertext, secretKey);

            // Print results
            System.out.println("Plaintext: " + plaintext);
            System.out.println("Ciphertext: " + ciphertext);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SecretKey generateDESKey(String keyString) throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(keyString.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(desKeySpec);
    }

    public static String encrypt(String plaintext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String ciphertext, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
