public class lc727 {

    public String minWindow(String S, String T) {
        int[][] dp = new int[T.length()][S.length()];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                dp[0][i] = i;
            }
        }
        for (int i = 1; i < T.length(); i++) {
            int pre = -1;
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == T.charAt(i) && pre != -1) {
                    dp[i][j] = pre;
                }
                if (dp[i - 1][j] != -1) {
                    pre = dp[i - 1][j];
                }
            }
        }
        int start = 0, end = Integer.MAX_VALUE / 2;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (dp[T.length() - 1][i] == -1) {
                continue;
            }
            int currEnd = i, currStart = dp[T.length() - 1][i];
            if (currEnd - currStart <= end - start) {
                start = currStart;
                end = currEnd;
            }
        }
        if (end == Integer.MAX_VALUE / 2) {
            return "";
        }
        return S.substring(start, end + 1);
    }

    public String minWindow(String S, String T) {
        int i = 0;
        int start = 0, end = 0;
        while (i < S.length()) {
            while (i < S.length() && S.charAt(i) != T.charAt(0)) {
                i++;
            }
            int iTmp = i, j = 0;
            while (iTmp < S.length() && j < T.length()) {
                if (S.charAt(iTmp) == T.charAt(j)) {
                    iTmp++;
                    j++;
                } else {
                    iTmp++;
                }
            }
            if (j == T.length() && iTmp - i < end - start) {
                start = i;
                end = iTmp;
            }
            i++;
        }
        return S.substring(start, end);
    }
    
    public static void main(String[] args) {
        lc727 lc = new lc727();
//        System.out.println(lc.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u"));
//        System.out.println(lc.minWindow("abcdebdde", "bde"));
//            System.out.println(lc.minWindow("spbmtkwqpftyahhnughzxscpavtqymtbanjyybdlhbphfrycpytsgzoeunvxaxuwbmecthomrjgmbvaoyjxxefmtxaxgwswdjdjlkpzsuirbujvhesfzdklgkulkmfnlofytaszwtxacnffvszmobxwmlhaxporskwzrvgmdpneggxqidqsdgvcprcnkdrxtsktibilbtggpazwuddhrgsmaspelglhausmfnyksdfyrwtpftrgtw",
//                    "asgvamuyus"));
        System.out.println(lc.minWindow("cnhczmccqouqadqtmjjzl", "mm"));
//        System.out.println();
    }
}
