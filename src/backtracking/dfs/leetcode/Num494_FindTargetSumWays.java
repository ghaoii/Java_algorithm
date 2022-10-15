package backtracking.dfs.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num494_FindTargetSumWays {
    // 状态压缩
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for(int i : nums) {
            sum +=i;
        }
        // 如果是奇数，那么不可能找到子集
        if(sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        sum = (sum + target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            // 从后遍历
            for (int j = sum; j >= 0; j--) {
                if(j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }

    // dp
//    public int findTargetSumWays(int[] nums, int target) {
//        int len = nums.length;
//        int sum = 0;
//        for(int i : nums) {
//            sum +=i;
//        }
//        // 如果是奇数，那么不可能找到子集
//        if(sum < Math.abs(target) || (sum + target) % 2 == 1) {
//            return 0;
//        }
//        sum = (sum + target) / 2;
//        int[][] dp = new int[len + 1][sum + 1];
//        dp[0][0] = 1;
//        for (int i = 1; i <= len; i++) {
//            for (int j = 0; j <= sum; j++) {
//                if(j >= nums[i - 1]) {
//                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
//                }else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[len][sum];
//    }
}

// 备忘录
//public class Num494_FindTargetSumWays {
//    private Map<String, Integer> map = new HashMap<>();
//    public int findTargetSumWays(int[] nums, int target) {
//        return dfs(nums, 0, target);
//    }
//
//    private int dfs(int[] nums, int i, int target) {
//        if(i == nums.length) {
//            if(target == 0) {
//                return 1;
//            }
//            return 0;
//        }
//        String str = i + "," + target;
//        if(map.containsKey(str)) {
//            return map.get(str);
//        }
//
//        int ret = dfs(nums, i + 1, target + nums[i]) + dfs(nums, i + 1, target - nums[i]);
//        map.put(str, ret);
//        return ret;
//    }
//}

// dfs
//public class Num494_FindTargetSumWays {
//    private int ret = 0;
//    public int findTargetSumWays(int[] nums, int target) {
//        if(nums.length == 0) {
//            return 0;
//        }
//        dfs(nums, 0, 0, target);
//        return ret;
//    }
//
//    private void dfs(int[] nums, int i, int sum, int target) {
//        if(i == nums.length) {
//            if(sum == target) {
//                ret++;
//            }
//            return;
//        }
//
//        // +i
//        dfs(nums, i + 1, sum + nums[i], target);
//        dfs(nums, i + 1, sum - nums[i], target);
//    }
//}
