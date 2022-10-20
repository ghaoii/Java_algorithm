package ds;

import java.util.HashMap;
import java.util.Map;

public class Num1_TwoSum {
    // Map解法
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num) && map.get(num) != i) {
                ret[0] = map.get(num);
                ret[1] = i;
            }
        }
        return ret;
    }

    // 暴力解法
//    public int[] twoSum(int[] nums, int target) {
//        int[] ret = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target) {
//                    ret[0] = i;
//                    ret[1] = j;
//                    return ret;
//                }
//            }
//        }
//        return ret;
//    }
}
