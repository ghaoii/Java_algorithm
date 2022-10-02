package dp.leetcode;

public class Num5_LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int start = 0;
        int end = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }else if(i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : 0;
                }

                if(dp[i][j] == 1 && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
