package dp.leetcode;

public class Num516_LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int prev = 0;
            for (int j = i; j < len; j++) {
                if(i == j) {
                    dp[j] = 1;
                    continue;
                }
                int temp = dp[j];// 保存当前的旧值，留给下一轮使用
                if(s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev + 2;
                }else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[len - 1];
    }

//    public int longestPalindromeSubseq(String s) {
//        int len = s.length();
//        int[][] dp = new int[len][len];
//        int max = 0;
//        for (int i = len - 1; i >= 0; i--) {
//            for (int j = i; j < len; j++) {
//                if(i == j) {
//                    dp[i][j] = 1;
//                }else if(i + 1 == j) {
//                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
//                }else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 2 : 0));
//                }
//            }
//        }
//        return dp[0][len - 1];
//    }
}
