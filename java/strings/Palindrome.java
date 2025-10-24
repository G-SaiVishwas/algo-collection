public class Palindrome
{
    public static boolean isPalindrome(int i, int j, String s) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        return isPalindrome(i + 1, j - 1, s);
    }

    public static boolean isPalindrome(String s) {
        return isPalindrome(0, s.length() - 1, s);
    }
}
