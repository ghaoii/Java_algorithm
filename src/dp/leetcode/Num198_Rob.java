package dp.leetcode;

public class Num198_Rob {
    // 状态压缩
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        // 0表示没偷，1表示偷了
        int a = 0;
        int b = nums[0];
        for (int i = 1; i < len; i++) {
            int temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }

    // dp2
//    public int rob(int[] nums) {
//        int len = nums.length;
//        if(len == 1) {
//            return nums[0];
//        }
//        // 0表示没偷，1表示偷了
//        int[] dp = new int[len + 1];
//        dp[1] = nums[0];
//        for (int i = 2; i <= len; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//        }
//        return dp[len];
//    }

    // dp1
//    public int rob(int[] nums) {
//        int len = nums.length;
//        // 0表示没偷，1表示偷了
//        int[][] dp = new int[len][2];
//        dp[0][1] = nums[0];
//        for (int i = 1; i < len; i++) {
//            // 如果不偷i，那么既可以偷i-1，也可以不偷i-1
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//            // 如果偷i，那么一定不偷i-1
//            dp[i][1] = dp[i - 1][0] + nums[i];
//        }
//        return Math.max(dp[len - 1][0], dp[len - 1][1]);
//    }
}
