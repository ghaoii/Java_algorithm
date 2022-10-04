package dp.leetcode;

public class Num213_Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, len - 1), helper(nums, 1, len));
    }

    private int helper(int[] nums, int start, int end) {
        int a = 0;
        int b = nums[start];
        for (int i = start + 1; i < end; i++) {
            int temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }
}
