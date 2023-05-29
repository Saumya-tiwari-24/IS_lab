public class SubstitutionCipher {
    public static void main(String[] args) {
        String input = "hello world";

        // Convert the string to a character array
        char[] characters = input.toCharArray();

        // Perform AND operation with 127
        System.out.print("AND Operation:");
        for (char c : characters) {
            char result = (char) (c & 127);
            System.out.print(result);
        }
        System.out.println();

        // Perform XOR operation with 127
        System.out.print("XOR Operation:");
        for (char c : characters) {
            char result = (char) (c ^ 127);
            System.out.print(result);
        }
        System.out.println();
    }
}
