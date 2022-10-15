package ds;

import java.util.*;

public class Num239_MaxSlidingWindow {
    // 优化后的写法
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
        }
        int[] ret = new int[nums.length - k + 1];
        int index = 0;
        for(int i = k; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
            ret[index++] = queue.peek();
            if(nums[i - k + 1] == queue.peek()) {
                queue.poll();
            }
        }
        return ret;
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        Deque<Integer> queue = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            if(i < k - 1) {
//                // 还没有达到窗口大小
//                while(!queue.isEmpty() && nums[i] > queue.peekLast()) {
//                    queue.pollLast();
//                }
//                queue.offer(nums[i]);
//            }else {
//                // 已经达到窗口大小
//                // 如果队尾元素小于当前元素则出队，如果等于则保留
//                while(!queue.isEmpty() && nums[i] > queue.peekLast()) {
//                    queue.pollLast();
//                }
//                // 当前元素入队
//                queue.offer(nums[i]);
//                // 保存当前窗口的最大值
//                list.add(queue.peek());
//                // 判断是否需要删除队首元素
//                // 这里可以通过数字进行判断，因为相同元素会保留
//                if(nums[i - k + 1] == queue.peek()) {
//                    queue.poll();
//                }
//            }
//        }
//        // 将List转换为数组
//        int[] ret = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ret[i] = list.get(i);
//        }
//        return ret;
//    }
}
