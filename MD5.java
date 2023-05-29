import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5{
    public static void main(String[] args) {
        String input = "Hello, world!";
        String md5Hash = md5(input);
        System.out.println("MD5 hash: " + md5Hash);
    }

    private static String md5(String input) {
        try {
            // Create an instance of MessageDigest with MD5 algorithm
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");

            // Convert the input string to bytes
            byte[] inputBytes = input.getBytes();

            // Update the digest with the input bytes
            md5Digest.update(inputBytes);

            // Calculate the hash value
            byte[] digestBytes = md5Digest.digest();

            // Convert the hash bytes to a hexadecimal string representation
            StringBuilder sb = new StringBuilder();
            for (byte b : digestBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
