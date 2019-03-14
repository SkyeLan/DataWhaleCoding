package DataWhale.Leetcode;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class _0345_ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        String vowel = "aoeiuAOEIU";
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < j && !vowel.contains(c[i] + ""))
                i++;
            while (i < j && !vowel.contains(c[j] + ""))
                j--;
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
