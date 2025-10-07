import java.util.*;

public class MorseCodeTranslator {
    private static final Map<Character, String> TO_MORSE = new HashMap<>();
    private static final Map<String, Character> FROM_MORSE = new HashMap<>();
    
    static {
        String[][] morseCode = {
            {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
            {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
            {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
            {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
            {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
            {"Z", "--.."}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, {"4", "....-"},
            {"5", "....."}, {"6", "-...."}, {"7", "--..."}, {"8", "---.."}, {"9", "----."},
            {"0", "-----"}, {" ", "/"}
        };
        
        for (String[] pair : morseCode) {
            TO_MORSE.put(pair[0].charAt(0), pair[1]);
            FROM_MORSE.put(pair[1], pair[0].charAt(0));
        }
    }
    
    public static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (TO_MORSE.containsKey(c)) {
                morse.append(TO_MORSE.get(c)).append(" ");
            }
        }
        return morse.toString().trim();
    }
    
    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (FROM_MORSE.containsKey(letter)) {
                    text.append(FROM_MORSE.get(letter));
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }
    
    public static void playMorseSound(String morse) throws InterruptedException {
        for (char c : morse.toCharArray()) {
            if (c == '.') {
                System.out.print("•");
                Thread.sleep(200);
            } else if (c == '-') {
                System.out.print("—");
                Thread.sleep(600);
            } else if (c == ' ') {
                System.out.print(" ");
                Thread.sleep(400);
            } else if (c == '/') {
                System.out.print(" / ");
                Thread.sleep(800);
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Morse Code Translator ===");
        System.out.println("1. Text to Morse");
        System.out.println("2. Morse to Text");
        System.out.print("Choose option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice == 1) {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();
            String morse = textToMorse(text);
            System.out.println("Morse Code: " + morse);
            System.out.print("Playing sound: ");
            playMorseSound(morse);
        } else {
            System.out.print("Enter morse code: ");
            String morse = scanner.nextLine();
            String text = morseToText(morse);
            System.out.println("Text: " + text);
        }
        
        scanner.close();
        System.out.println("\n Super Contribute");
    }
}