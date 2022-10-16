package backtracking.dfs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num77_Combine {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int cur, List<Integer> list) {
        if(k == 0) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        if(cur > n) {
            return;
        }
        for (int i = cur; i <= n; i++) {
            // 做出选择
            list.add(i);
            // 深度递归(从下一个位置开始)
            dfs(n, k - 1, i + 1, list);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }
}
