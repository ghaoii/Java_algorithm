package backtracking.dfs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num46_Permute {
    // 排列的结果集
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 创建标记数组，0表示未使用，1表示已使用
        int[] book = new int[nums.length];
        dfs(nums, book, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int[] book, int cur, List<Integer> list) {
        if(cur == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(book[i] == 0) {
                // 做出选择
                list.add(nums[i]);
                // 更新当前元素的状态
                book[i] = 1;
                // 深度递归
                dfs(nums, book, cur + 1, list);
                // 撤销选择并还原状态
                list.remove(cur);
                book[i] = 0;
            }
        }
    }
}
