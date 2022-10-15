package monotonous_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num503_NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int[] ret = new int[len];
        List<Integer> list = new ArrayList<>();
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            ret[i] = stack.isEmpty() ? -1 : stack.peek();
            // 没有找到下一个更大元素
            // 这里不能通过ret[i] == -1 来判断，因为要避免下一个更大元素是-1的情况
            if(stack.isEmpty()) {
                list.add(i);
            }
            stack.push(nums[i]);
        }

        for(int i : list) {
            while(!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            ret[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ret;
    }


    // 遍历两次数组
//    public int[] nextGreaterElements(int[] nums) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int len = nums.length;
//        int[] ret = new int[len];
//        for(int i = len * 2 - 1; i >= 0; i--) {
//            // 通过 % 来防止越界
//            while(!stack.isEmpty() && nums[i % len] >= stack.peek()) {
//                stack.pop();
//            }
//            ret[i % len] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(nums[i % len]);
//        }
//        return ret;
//    }
}
