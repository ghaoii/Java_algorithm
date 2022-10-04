package dp.leetcode;

public class Num416_CanPartition {
    // 状态压缩后的dp
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum % 2 == 1) {
            return false;
        }
        int half = sum >> 1;
        int len = nums.length;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = half; j > 0; j--) {
                if(j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
                // 如果是 j < nums[i - 1]的情况，是继承上一行的结果
                // 因此在状态压缩的情况下，不需要改
            }
        }
        return dp[half];
    }

//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for(int i : nums) {
//            sum += i;
//        }
//        if(sum % 2 == 1) {
//            return false;
//        }
//        int half = sum >> 1;
//        int len = nums.length;
//        // dp(i,j): 在前i个数中，是否存在子集之和正好等于j
//        int[][] dp = new int[len + 1][half + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= len; i++) {
//            for (int j = 1; j <= half; j++) {
//                if(nums[i - 1] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                }else {
//                    if(dp[i - 1][j] == 1 || dp[i - 1][j - nums[i - 1]] == 1) {
//                        dp[i][j] = 1;
//                    }
//                }
//            }
//        }
//        return dp[len][half] == 1;
//    }
}
