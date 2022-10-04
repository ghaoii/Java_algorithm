package dp.leetcode;

public class Num312_MaxCoins {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 2];
        for (int i = 1; i <= len; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[len + 1] = 1;
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len; i >= 0; i--) {
            for (int j = i + 1; j < len + 2; j++) {
                // k不能取到i和j，因为是开区间
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][len + 1];
    }
}
