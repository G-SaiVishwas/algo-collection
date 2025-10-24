import java.util.*;
import java.util.stream.*;

public class AnagramMaster {
    private static final Map<String, String> DICTIONARY = new HashMap<>();
    
    static {
        // Sample dictionary
        String[] words = {"listen", "silent", "enlist", "triangle", "integral", "alert", "alter", "later"};
        for (String word : words) {
            DICTIONARY.put(word, getSortedKey(word));
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("🔤 Advanced Anagram Analyzer");
        System.out.println("1. Check Anagram Pair");
        System.out.println("2. Find All Anagrams");
        System.out.println("3. Generate Anagrams");
        System.out.print("Choose operation (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice) {
            case 1:
                System.out.print("Enter first word: ");
                String word1 = scanner.nextLine();
                System.out.print("Enter second word: ");
                String word2 = scanner.nextLine();
                checkAnagramPair(word1, word2);
                break;
            case 2:
                System.out.print("Enter word to find anagrams: ");
                String word = scanner.nextLine();
                findAllAnagrams(word);
                break;
            case 3:
                System.out.print("Enter word to generate anagrams: ");
                String input = scanner.nextLine();
                generateAnagrams(input);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void checkAnagramPair(String word1, String word2) {
        boolean isAnagram = isAnagram(word1, word2);
        System.out.println("\n🔍 Analysis Result:");
        System.out.println(word1 + " ↔ " + word2 + " : " + 
                          (isAnagram ? "✅ ANAGRAMS" : "❌ NOT ANAGRAMS"));
        
        if (isAnagram) {
            System.out.println("Character frequency:");
            displayFrequencyAnalysis(word1, word2);
        }
    }
    
    private static void findAllAnagrams(String word) {
        String key = getSortedKey(word);
        List<String> anagrams = DICTIONARY.entrySet().stream()
            .filter(entry -> entry.getValue().equals(key) && !entry.getKey().equals(word))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        System.out.println("\n📚 Found " + anagrams.size() + " anagrams:");
        anagrams.forEach(anagram -> System.out.println("• " + anagram));
        
        if (!anagrams.isEmpty()) {
            System.out.println("\n🎯 Anagram Group: " + String.join(" ↔ ", anagrams));
        }
    }
    
    private static void generateAnagrams(String word) {
        System.out.println("\n🎲 Generating anagrams for: " + word);
        Set<String> permutations = generatePermutations(word);
        
        List<String> validAnagrams = permutations.stream()
            .filter(perm -> isValidWord(perm) && !perm.equals(word))
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println("Generated " + validAnagrams.size() + " valid anagrams:");
        validAnagrams.forEach(anagram -> System.out.println("• " + anagram));
        
        // Display pattern analysis
        analyzePattern(word);
    }
    
    private static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        return getSortedKey(word1).equals(getSortedKey(word2));
    }
    
    private static String getSortedKey(String word) {
        return word.toLowerCase().chars()
            .sorted()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining());
    }
    
    private static void displayFrequencyAnalysis(String word1, String word2) {
        Map<Character, Integer> freq1 = getFrequency(word1);
        Map<Character, Integer> freq2 = getFrequency(word2);
        
        System.out.println("Word1: " + formatFrequency(freq1));
        System.out.println("Word2: " + formatFrequency(freq2));
    }
    
    private static Map<Character, Integer> getFrequency(String word) {
        return word.toLowerCase().chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }
    
    private static String formatFrequency(Map<Character, Integer> freq) {
        return freq.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(entry -> entry.getKey() + ":" + entry.getValue())
            .collect(Collectors.joining(", "));
    }
    
    private static Set<String> generatePermutations(String word) {
        Set<String> result = new HashSet<>();
        generatePermutations("", word.toLowerCase(), result);
        return result;
    }
    
    private static void generatePermutations(String prefix, String remaining, Set<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
            return;
        }
        
        for (int i = 0; i < remaining.length(); i++) {
            generatePermutations(prefix + remaining.charAt(i), 
                               remaining.substring(0, i) + remaining.substring(i + 1), 
                               result);
        }
    }
    
    private static boolean isValidWord(String word) {
        return DICTIONARY.containsKey(word);
    }
    
    private static void analyzePattern(String word) {
        String sorted = getSortedKey(word);
        int uniqueChars = (int) word.chars().distinct().count();
        int vowelCount = (int) word.toLowerCase().chars()
            .filter(c -> "aeiou".indexOf(c) != -1).count();
        
        System.out.println("\n📊 Pattern Analysis:");
        System.out.println("Sorted characters: " + sorted);
        System.out.println("Unique characters: " + uniqueChars);
        System.out.println("Vowel count: " + vowelCount);
        System.out.println("Possible combinations: " + 
            factorial(word.length()) + " (theoretical)");
    }
    
    private static int factorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }
}
