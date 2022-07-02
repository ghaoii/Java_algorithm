package backtracking.dfs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num39_CombinationSum {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    private void dfs(int[] candidates, int target, int index, int oldSum) {
        if(oldSum >= target) {
            if(oldSum == target){
                // 由于原来的list还需要修改，所以这里得用新的线性表拷贝
                List<Integer> newList = new ArrayList<>();
                for(int e : list) {
                    newList.add(e);
                }
                ret.add(newList);
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, i, oldSum + candidates[i]);
            // 回溯
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0);
        return ret;
    }
}
