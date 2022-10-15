package monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Num496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            // 如果栈中存在元素，且小于等于将要入栈的元素
            while(!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();// 让较小值出栈
            }
            int next = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], next);
            stack.push(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}
