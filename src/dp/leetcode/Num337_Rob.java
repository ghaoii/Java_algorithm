package dp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num337_Rob {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(map.containsKey(root))
            return map.get(root);

        // 如果当前结点要偷，那么去下下家取
        int getMoney = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        // 如果当前结点不偷，那么到下家取
        int notGetMoney = rob(root.left) + rob(root.right);

        int max = Math.max(getMoney, notGetMoney);
        map.put(root, max);
        return max;
    }
}
