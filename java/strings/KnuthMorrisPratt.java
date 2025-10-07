public class KnuthMorrisPratt {
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    public static int[] findPattern(String text, String pattern) {
        if (text == null || pattern == null) {
            throw new IllegalArgumentException("Text and pattern cannot be null");
        }
        int[] matches = new int[text.length()];
        int matchCount = 0;
        int[] lps = computeLPSArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                matches[matchCount++] = i - j;
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        int[] result = new int[matchCount];
        System.arraycopy(matches, 0, result, 0, matchCount);
        return result;
    }
    
    public static void main(String[] args) {
        String text1 = "AABAACAADAABAAABAA";
        String pattern1 = "AABA";
        System.out.println("Test Case 1:");
        System.out.println("Text: " + text1);
        System.out.println("Pattern: " + pattern1);
        System.out.print("Pattern found at indices: ");
        int[] result1 = findPattern(text1, pattern1);
        for (int index : result1) {
            System.out.print(index + " ");
        }
        System.out.println("\n");
        
        String text2 = "ABABABAB";
        String pattern2 = "ABA";
        System.out.println("Test Case 2:");
        System.out.println("Text: " + text2);
        System.out.println("Pattern: " + pattern2);
        System.out.print("Pattern found at indices: ");
        int[] result2 = findPattern(text2, pattern2);
        for (int index : result2) {
            System.out.print(index + " ");
        }
        System.out.println("\n");
        
        String text3 = "Hello, World!";
        String pattern3 = "Python";
        System.out.println("Test Case 3:");
        System.out.println("Text: " + text3);
        System.out.println("Pattern: " + pattern3);
        System.out.print("Pattern found at indices: ");
        int[] result3 = findPattern(text3, pattern3);
        if (result3.length == 0) {
            System.out.println("Pattern not found");
        }
    }
}