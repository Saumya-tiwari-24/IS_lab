public class RailFenceCipher {
    public static void main(String[] args) {
        String plaintext = "HELLO, RAIL FENCE CIPHER";
        int rails = 3;

        String ciphertext = encrypt(plaintext, rails);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = decrypt(ciphertext, rails);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    public static String encrypt(String plaintext, int rails) {
        char[][] fence = new char[rails][plaintext.length()];
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                fence[i][j] = '.';
            }
        }

        int rail = 0;
        boolean down = false;
        for (int i = 0; i < plaintext.length(); i++) {
            fence[rail][i] = plaintext.charAt(i);

            if (rail == 0 || rail == rails - 1) {
                down = !down;
            }

            rail += down ? 1 : -1;
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                if (fence[i][j] != '.') {
                    ciphertext.append(fence[i][j]);
                }
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int rails) {
        char[][] fence = new char[rails][ciphertext.length()];
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < ciphertext.length(); j++) {
                fence[i][j] = '.';
            }
        }

        int rail = 0;
        boolean down = false;
        for (int i = 0; i < ciphertext.length(); i++) {
            if (rail == 0 || rail == rails - 1) {
                down = !down;
            }

            fence[rail][i] = '*';
            rail += down ? 1 : -1;
        }

        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < ciphertext.length(); j++) {
                if (fence[i][j] == '*' && index < ciphertext.length()) {
                    fence[i][j] = ciphertext.charAt(index);
                    index++;
                }
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        rail = 0;
        down = false;
        for (int i = 0; i < ciphertext.length(); i++) {
            decryptedText.append(fence[rail][i]);

            if (rail == 0 || rail == rails - 1) {
                down = !down;
            }

            rail += down ? 1 : -1;
        }

        return decryptedText.toString();
    }
}
