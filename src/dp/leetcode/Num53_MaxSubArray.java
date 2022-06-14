package dp.leetcode;

import com.sun.xml.internal.ws.encoding.MtomCodec;

public class Num53_MaxSubArray {
    //优化
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], pre + nums[i]);
            pre = temp;
            max = Math.max(max, temp);
        }
        return max;
    }


    //未优化
//    public int maxSubArray(int[] nums) {
//        int len = nums.length;
//        int[] maxS = new int[len + 1];
//        maxS[1] = nums[0];
//        int pre = nums[0];
//        for (int i = 2; i <= len; i++) {
//            maxS[i] = Math.max(nums[i - 1], maxS[i - 1] + nums[i - 1]);
//        }
//        int max = maxS[1];
//        for (int i = 2; i <= len; i++) {
//            max = Math.max(maxS[i], max);
//        }
//        return max;
//    }
}
