package backtracking.dfs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num22_GenerateParenthesis {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(int n, int left, int right, StringBuilder sb) {
        if(left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if(left == n) {
            dfs(n, left, right + 1, sb.append(')'));
        }else if(left > right) {
            dfs(n, left + 1, right, sb.append("("));
            sb.delete(sb.length() - 1, sb.length());
            dfs(n, left, right + 1, sb.append(")"));
        }else {
            dfs(n, left + 1, right, sb.append("("));
        }
        sb.delete(sb.length() - 1, sb.length());
    }
}
