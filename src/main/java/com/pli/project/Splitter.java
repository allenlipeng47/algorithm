import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App2 {

/*
    98+8/8 分为98 8 / 8
 */
    public static void main(String[] args) {
        System.out.println(transform("98+8/8"));
    }

    public static Set<Character> chSet = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public static String transform(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                if (sb.length() != 0) {
                    ans.append(sb).append(' ');
                    sb = new StringBuilder();
                }
            } else if (chSet.contains(ch)) {
                if (sb.length() != 0) {
                    ans.append(sb).append(' ');
                    sb = new StringBuilder();
                }
                ans.append(ch).append(' ');
            } else {
                sb.append(ch);
            }
        }
        if (sb.length() != 0) {
            ans.append(sb);
        }
        return ans.toString();
    }



}
