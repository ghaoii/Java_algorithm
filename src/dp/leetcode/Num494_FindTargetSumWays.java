package dp.leetcode;

public class Num494_FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int row = nums.length;
        int col = 0;
        for (int num : nums) {
            col += num;
        }
        if(target > col) {
            return 0;
        }
        int[][] sum = new int[row + 1][col * 2 + 1];
        //初始化
        sum[0][col] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = -col; j <= col; j++) {
                int x = nums[i - 1];
                if(j + x <= col) {
                    sum[i][j + col] += sum[i - 1][j + x + col];
                }
                if(j - x >= -col) {
                    sum[i][j + col] += sum[i - 1][j - x + col];
                }
            }
        }
        return sum[row][target + col];
    }
}

//public class Num494_FindTargetSumWays {
//
//    public int findTargetSumWays(int[] nums, int target) {
//        int lastIndex = nums.length - 1;
//        return helper(nums, lastIndex, target);
//    }
//
//    // 递归方法语意 - 传入一个数组和目标值，就能算出通过对数组元素加减得到目标值的方法总数
//    private int helper(int[] nums, int lastIndex, int target) {
//        if(lastIndex == 0) {
//            if(nums[lastIndex] == target && -nums[lastIndex] == target) {
//                return 2;
//            }
//            if(nums[lastIndex] == target || -nums[lastIndex] == target) {
//                return 1;
//            }
//            return 0;
//        }
//        return helper(nums, lastIndex - 1, target - nums[lastIndex])
//                + helper(nums, lastIndex - 1, target + nums[lastIndex]);
//    }
//}
