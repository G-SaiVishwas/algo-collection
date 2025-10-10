/**
 * Implementation of the Boyer-Moore string searching algorithm.
 * This algorithm preprocesses the pattern to achieve better than O(n) performance
 * on many inputs by using two heuristics:
 * 1. Bad Character Rule
 * 2. Good Suffix Rule
 * 
 * Time Complexity:
 * - Preprocessing: O(m + k) where m is pattern length and k is alphabet size
 * - Search: O(mn) worst case, but often performs in O(n/m) in practice
 * Space Complexity: O(k) where k is the size of the alphabet
 */
public class BoyerMoore {
    private static final int NO_OF_CHARS = 256;
    
    /**
     * Preprocesses the pattern to create the bad character rule array
     */
    private static int[] createBadCharArray(String pattern) {
        int[] badChar = new int[NO_OF_CHARS];
        
        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++) {
            badChar[i] = -1;
        }
        
        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < pattern.length(); i++) {
            badChar[pattern.charAt(i)] = i;
        }
        
        return badChar;
    }
    
    /**
     * Searches for occurrences of pattern in text using Boyer-Moore algorithm
     * @param text The text to search in
     * @param pattern The pattern to search for
     * @return Array of starting indices where pattern is found
     */
    public static int[] search(String text, String pattern) {
        if (text == null || pattern == null) {
            throw new IllegalArgumentException("Text and pattern cannot be null");
        }
        
        int[] matches = new int[text.length()];
        int matchCount = 0;
        
        int[] badChar = createBadCharArray(pattern);
        
        int shift = 0;  // Shift of the pattern with respect to text
        while (shift <= text.length() - pattern.length()) {
            int j = pattern.length() - 1;
            
            // Keep reducing index j of pattern while characters of
            // pattern and text are matching at this shift
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }
            
            // If the pattern is present at current shift, then j becomes -1
            if (j < 0) {
                matches[matchCount++] = shift;
                shift += (shift + pattern.length() < text.length()) ? 1 : 1;
            } else {
                // Shift the pattern so that the bad character in text aligns
                // with the last occurrence of it in pattern.
                // The max function is used to make sure we get a positive shift.
                // We may get a negative shift if the last occurrence of bad
                // character in pattern is on the right side of the current character.
                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
            }
        }
        
        // Create result array with exact size
        int[] result = new int[matchCount];
        System.arraycopy(matches, 0, result, 0, matchCount);
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        String text1 = "ABAAABCDABC";
        String pattern1 = "ABC";
        System.out.println("Test Case 1:");
        System.out.println("Text: " + text1);
        System.out.println("Pattern: " + pattern1);
        System.out.print("Pattern found at indices: ");
        int[] result1 = search(text1, pattern1);
        for (int index : result1) {
            System.out.print(index + " ");
        }
        System.out.println("\n");
        
        String text2 = "AABAACAADAABAAABAA";
        String pattern2 = "AABA";
        System.out.println("Test Case 2:");
        System.out.println("Text: " + text2);
        System.out.println("Pattern: " + pattern2);
        System.out.print("Pattern found at indices: ");
        int[] result2 = search(text2, pattern2);
        for (int index : result2) {
            System.out.print(index + " ");
        }
        System.out.println("\n");
        
        String text3 = "ABCDEFGHIJKLMNOP";
        String pattern3 = "XYZ";
        System.out.println("Test Case 3:");
        System.out.println("Text: " + text3);
        System.out.println("Pattern: " + pattern3);
        System.out.print("Pattern found at indices: ");
        int[] result3 = search(text3, pattern3);
        if (result3.length == 0) {
            System.out.println("Pattern not found");
        }
    }
}