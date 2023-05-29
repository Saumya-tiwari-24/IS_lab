import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
    public static void main(String[] args) {
        String input = "Hello, world!";
        String sha1Hash = sha1(input);
        System.out.println("SHA-1 hash: " + sha1Hash);
    }

    private static String sha1(String input) {
        try {
            // Create an instance of MessageDigest with SHA-1 algorithm
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");

            // Convert the input string to bytes
            byte[] inputBytes = input.getBytes();

            // Update the digest with the input bytes
            sha1Digest.update(inputBytes);

            // Calculate the hash value
            byte[] digestBytes = sha1Digest.digest();

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
