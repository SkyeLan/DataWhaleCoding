package DataWhale.Leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric
 * characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class _0125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < j && !(Character.isLetter(c[i]) || Character.isDigit(c[i])))
                i++;
            while (i < j && !(Character.isLetter(c[j]) || Character.isDigit(c[j])))
                j--;
            if (c[i] != c[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
