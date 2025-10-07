import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

    private Anagrams() {
    }

    public static boolean areAnagramsBySorting(String s, String t) {
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        if (s.length() != t.length()) {
            return false;
        }
        char[] c = s.toCharArray();
        char[] d = t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        return Arrays.equals(c, d);
    }

    public static boolean areAnagramsByCountingChars(String s, String t) {
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        int[] dict = new int[128];
        for (char ch : s.toCharArray()) {
            dict[ch]++;
        }
        for (char ch : t.toCharArray()) {
            dict[ch]--;
        }
        for (int e : dict) {
            if (e != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagramsByCountingCharsSingleArray(String s, String t) {
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagramsUsingHashMap(String s, String t) {
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c) || charCountMap.get(c) == 0) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
        }
        return charCountMap.values().stream().allMatch(count -> count == 0);
    }

    public static boolean areAnagramsBySingleFreqArray(String s, String t) {
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "Listen";
        String s2 = "Silent";
        String s3 = "Hello";

        System.out.println("areAnagramsBySorting: " + areAnagramsBySorting(s1, s2));
        System.out.println("areAnagramsByCountingChars: " + areAnagramsByCountingChars(s1, s2));
        System.out.println("areAnagramsByCountingCharsSingleArray: " + areAnagramsByCountingCharsSingleArray(s1, s2));
        System.out.println("areAnagramsUsingHashMap: " + areAnagramsUsingHashMap(s1, s2));
        System.out.println("areAnagramsBySingleFreqArray: " + areAnagramsBySingleFreqArray(s1, s2));

        System.out.println("\nChecking with non-anagram:");
        System.out.println("areAnagramsBySorting: " + areAnagramsBySorting(s1, s3));
        System.out.println("areAnagramsByCountingChars: " + areAnagramsByCountingChars(s1, s3));
        System.out.println("areAnagramsByCountingCharsSingleArray: " + areAnagramsByCountingCharsSingleArray(s1, s3));
        System.out.println("areAnagramsUsingHashMap: " + areAnagramsUsingHashMap(s1, s3));
        System.out.println("areAnagramsBySingleFreqArray: " + areAnagramsBySingleFreqArray(s1, s3));
    }
}
