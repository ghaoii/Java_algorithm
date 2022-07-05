package backtracking.dfs.leetcode;

import java.util.ArrayList;
import java.util.List;

// 用于存储每一行的位置
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Num51_SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<Pair>> allRes = new ArrayList<>();
        List<Pair> curRes = new ArrayList<>();
        dfs(allRes, curRes, 0, n);
        List<List<String>> ret = transform(allRes, n);
        return ret;
    }

    private List<List<String>> transform(List<List<Pair>> allRes, int n) {
        List<List<String>> ret = new ArrayList<>();
        for (List<Pair> pairs : allRes) {
            List<StringBuilder> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(".");
                }
                temp.add(sb);
            }
            for (Pair pair : pairs) {
                temp.get(pair.x).setCharAt(pair.y, 'Q');
            }
            List<String> curRes = new ArrayList<>();
            for (StringBuilder curRow : temp) {
                curRes.add(curRow.toString());
            }
            ret.add(curRes);
        }
        return ret;
    }

    private void dfs(List<List<Pair>> allRes, List<Pair> curRes, int curRow, int n) {
        // 如果n个皇后都放置好了，就把这种方案放到结果集中
        if (curRow == n) {
            List<Pair> temp = new ArrayList<>();
            for (Pair pair : curRes) {
                temp.add(pair);
            }
            allRes.add(temp);
        }
        for (int i = 0; i < n; i++) {
            if (isValid(curRes, curRow, i)) {
                curRes.add(new Pair(curRow, i));
                dfs(allRes, curRes, curRow + 1, n);
                curRes.remove(curRow);
            }
        }
    }

    private boolean isValid(List<Pair> curRes, int curRow, int col) {
        for (Pair pair : curRes) {
            if (pair.y == col || pair.x + pair.y == curRow + col || pair.x - pair.y == curRow - col) {
                return false;
            }
        }
        return true;
    }

}
