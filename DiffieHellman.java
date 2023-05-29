import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {
    public static void main(String[] args) {
        // Generate prime number and primitive root
        BigInteger p = generatePrimeNumber();
        BigInteger g = generatePrimitiveRoot(p);

        // Alice's and Bob's private keys
        BigInteger a = generatePrivateKey();
        BigInteger b = generatePrivateKey();

        // Calculate public keys
        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);

        // Calculate shared secret keys
        BigInteger secretKeyA = B.modPow(a, p);
        BigInteger secretKeyB = A.modPow(b, p);

        // Check if the shared secret keys match
        if (secretKeyA.equals(secretKeyB)) {
            System.out.println("Shared secret key: " + secretKeyA);
        } else {
            System.out.println("Error: Shared secret keys do not match.");
        }
    }

    private static BigInteger generatePrimeNumber() {
        // Generate a random prime number of a desired bit length
        return BigInteger.probablePrime(512, new SecureRandom());
    }

    private static BigInteger generatePrimitiveRoot(BigInteger p) {
        // Find a primitive root modulo p
        BigInteger g = BigInteger.TWO;
        while (g.compareTo(p.subtract(BigInteger.ONE)) < 0) {
            if (g.modPow(BigInteger.valueOf(2), p).equals(BigInteger.ONE) &&
                    g.modPow(p.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2)), p).equals(BigInteger.ONE)) {
                return g;
            }
            g = g.add(BigInteger.ONE);
        }
        return null;
    }

    private static BigInteger generatePrivateKey() {
        // Generate a random private key within a certain range
        BigInteger maxRange = BigInteger.TEN.pow(10);
        SecureRandom random = new SecureRandom();
        return new BigInteger(maxRange.bitLength(), random).mod(maxRange);
    }
}
