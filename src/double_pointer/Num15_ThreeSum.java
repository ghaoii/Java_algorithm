package double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, 0 - nums[i]);
            for(List<Integer> temp : twoSumRes) {
                // 不要求返回顺序，因此直接添加
                temp.add(nums[i]);
                ret.add(temp);
            }
            while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ret;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            int leftNum = nums[left];
            int rightNum = nums[right];
            if(sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(leftNum);
                temp.add(rightNum);
                ret.add(temp);
                while(left < right && nums[left] == leftNum) {
                    left++;
                }
                while(right > left && nums[right] == rightNum) {
                    right--;
                }
            }else if(sum < target) {
                while(left < right && nums[left] == leftNum) {
                    left++;
                }
            }else{
                while(right > left && nums[right] == rightNum) {
                    right--;
                }
            }
        }
        return ret;
    }
}
