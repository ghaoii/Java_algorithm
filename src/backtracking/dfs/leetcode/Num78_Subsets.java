package backtracking.dfs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num : nums) {
            // 必须取得当前res的长度，因为在内存循环中res的size在不断改变，所以无法作为循环的判断条件
            int size = res.size();
            // 将num添加到当前所有子集后面
            for (int i = 0; i < size; i++) {
                // 要创建新的引用
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}

//public class Num78_Subsets {
//    private List<List<Integer>> ret = new ArrayList<>();
//
//    public List<List<Integer>> subsets(int[] nums) {
//        if(nums == null || nums.length == 0) {
//            return ret;
//        }
//        // 先添加空集
//        ret.add(new ArrayList<>());
//
//        dfs(nums, 0, new ArrayList<>());
//        return ret;
//    }
//
//    private void dfs(int[] nums, int cur, List<Integer> list) {
//        if(cur == nums.length) {
//            return;
//        }
//        for (int i = cur; i < nums.length; i++) {
//            // 做选择
//            list.add(nums[i]);
//            // 保存结果(这里不能直接保存list集合的引用，因为list是不断在改变的)
//            List<Integer> temp = new ArrayList<>(list);
//            ret.add(temp);
//            // 深度递归
//            dfs(nums, i + 1, list);
//            // 撤销选择
//            list.remove(list.size() - 1);
//        }
//    }
//}
