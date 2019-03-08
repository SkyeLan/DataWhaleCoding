package DataWhale.Task4;

public class NavieStringMatch {
    public static int stringMatcher(String S, String target) {
        for (int i = 0; i < S.length(); i++) {
            int k = i;
            for (int j = 0; j < target.length(); j++) {
                if (S.charAt(k) == target.charAt(j)) {
                    k++;
                    if (j == target.length() - 1) {
                        return i;
                    }
                } else
                    break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String S = "qwertyuiopasdfghjklzxcvbnm";
        String target = "asdfghjkl";
        System.out.println("有效位移是： " + stringMatcher(S, target));
    }
}
