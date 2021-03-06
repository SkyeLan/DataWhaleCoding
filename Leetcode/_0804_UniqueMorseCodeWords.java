package DataWhale.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a
 * series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps
 * to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
 * ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code
 * of each letter. For example, "cba" can be written as "-.-..--...", (which is the
 * concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation
 * of a word.
 * Return the number of different transformations among all words we have.
 * <p>
 * Note:
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */
public class _0804_UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] moss = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            for (char c : word.toCharArray()) {
                sb.append(moss[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
