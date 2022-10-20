package double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    // n数之和
    private List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
        List<List<Integer>> ret = new ArrayList<>();
        // 如果n小于2或者数组总长度不足n，无法找到答案，直接返回
        if(n < 2 || nums.length < n) {
            return ret;
        }
        if(n == 2) {
            int left = start;
            int right = nums.length - 1;
            while(left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int sum = leftNum + rightNum;
                if(sum == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(leftNum);
                    temp.add(rightNum);
                    ret.add(temp);
                    while(left < right && nums[left] == leftNum) {
                        left++;
                    }
                    while(left < right && nums[right] == rightNum) {
                        right--;
                    }
                }else if(sum < target) {
                    while(left < right && nums[left] == leftNum) {
                        left++;
                    }
                }else {
                    while(left < right && nums[right] == rightNum) {
                        right--;
                    }
                }
            }
        }else {
            for (int i = start; i < nums.length; i++) {
                long num = target - nums[i];
                List<List<Integer>> lists = nSum(nums, n - 1, i + 1, num);
                for(List<Integer> list : lists) {
                    list.add(nums[i]);
                    ret.add(list);
                }
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return ret;
    }
}

//public class Num18_FourSum {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<List<Integer>> ret = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            long num = target - nums[i];
//            List<List<Integer>> lists = threeSum(nums, i + 1, num);
//            for(List<Integer> list : lists) {
//                list.add(nums[i]);
//                ret.add(list);
//            }
//            while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
//                i++;
//            }
//        }
//        return ret;
//    }
//
//    private List<List<Integer>> threeSum(int[] nums, int start, long target) {
//        List<List<Integer>> ret = new ArrayList<>();
//        for (int i = start; i < nums.length; i++) {
//            long num = target - nums[i];
//            List<List<Integer>> lists = twoSum(nums, i + 1, num);
//            for(List<Integer> list : lists) {
//                list.add(nums[i]);
//                ret.add(list);
//            }
//            while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
//                i++;
//            }
//        }
//        return ret;
//    }
//
//    private List<List<Integer>> twoSum(int[] nums, int start, long target) {
//        List<List<Integer>> ret = new ArrayList<>();
//        int left = start;
//        int right= nums.length - 1;
//        while(left < right) {
//            int leftNum = nums[left];
//            int rightNum = nums[right];
//            int sum = leftNum + rightNum;
//            List<Integer> temp = new ArrayList<>();
//            if(sum == target) {
//                temp.add(leftNum);
//                temp.add(rightNum);
//                ret.add(temp);
//                while(left < right && nums[left] == leftNum) {
//                    left++;
//                }
//                while(right > left && nums[right] == rightNum) {
//                    right--;
//                }
//            }else if(sum < target){
//                while(left < right && nums[left] == leftNum) {
//                    left++;
//                }
//            }else {
//                while(right > left && nums[right] == rightNum) {
//                    right--;
//                }
//            }
//        }
//        return ret;
//    }
//}
