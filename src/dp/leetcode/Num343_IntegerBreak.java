package dp.leetcode;

public class Num343_IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        //初始化
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
