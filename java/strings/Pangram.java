import java.util.HashSet;

public class Pangram {

    private Pangram() {
    }

    public static void main(String[] args) {
        String[] tests = {
            "The quick brown fox jumps over the lazy dog",
            "The quick brown fox jumps over the azy dog",
            "+-1234 This string is not alphabetical",
            "\u0000/\\"
        };

        for (String test : tests) {
            System.out.println("Testing: \"" + test + "\"");
            System.out.println("isPangram: " + isPangram(test));
            System.out.println("isPangramUsingSet: " + isPangramUsingSet(test));
            System.out.println("isPangram2: " + isPangram2(test));
            System.out.println();
        }
    }

    public static boolean isPangramUsingSet(String s) {
        HashSet<Character> alpha = new HashSet<>();
        s = s.trim().toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                alpha.add(s.charAt(i));
            }
        }
        return alpha.size() == 26;
    }

    public static boolean isPangram(String s) {
        boolean[] lettersExisting = new boolean[26];
        for (char c : s.toCharArray()) {
            int letterIndex = c - (Character.isUpperCase(c) ? 'A' : 'a');
            if (letterIndex >= 0 && letterIndex < lettersExisting.length) {
                lettersExisting[letterIndex] = true;
            }
        }
        for (boolean letterFlag : lettersExisting) {
            if (!letterFlag) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPangram2(String s) {
        if (s.length() < 26) {
            return false;
        }
        s = s.toLowerCase();
        for (char i = 'a'; i <= 'z'; i++) {
            if (s.indexOf(i) == -1) {
                return false;
            }
        }
        return true;
    }
}
