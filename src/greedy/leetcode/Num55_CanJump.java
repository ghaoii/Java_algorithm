package greedy.leetcode;

public class Num55_CanJump {
//    public boolean canJump(int[] nums) {
//        int len = nums.length;
//        if(len == 1) {
//            return true;
//        }
//        int jump = nums[0];// 记录能跳的最远距离
//        for (int i = 1; i < len; i++) {
//            if(jump >= i) {
//                jump = Math.max(jump, i + nums[i]);
//                if(jump >= len - 1) {
//                    return true;
//                }
//            }else {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return true;
        }
        int jump = nums[0];
        if(jump == 0) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            jump--;
            if(nums[i] >= jump) {
                jump = nums[i];
            }
            if(jump == 0 && i < len - 1) {
                return false;
            }
        }
        return true;
    }
}
