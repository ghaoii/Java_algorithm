package dp.leetcode;

public class Num1312_MinInsertions {
    public int minInsertions(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = len - 1; i >= 0 ; i--) {
            int prev = 0;
            for (int j = i; j < len; j++) {
                if(i == j) {
                    continue;
                }
                int temp = dp[j];
                if(s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev;
                }else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                }
                prev = temp;
            }
        }
        return dp[len - 1];
    }

//    public int minInsertions(String s) {
//        int len = s.length();
//        int[][] dp = new int[len][len];
//        for (int i = len - 1; i >= 0; i--) {
//            for (int j = i; j < len; j++) {
//                if(i == j) {
//                    continue;
//                }
//                if(s.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = dp[i + 1][j - 1];
//                }else {
//                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
//                }
//            }
//        }
//        return dp[0][len - 1];
//    }
}
