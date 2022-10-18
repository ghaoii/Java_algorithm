package backtracking.bfs.leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Num773_SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        // 先保存初始状态
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        // 提前保存好0的每种情况
        int[][] next = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};
        // 希望的解
        String target = "123450";
        Deque<String> queue = new LinkedList<>();
        queue.offer(sb.toString());
        Set<String> set = new HashSet<>();
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 达到target，返回当前步数
                if(target.equals(cur)) {
                    return count;
                }
                // 没达到target，继续遍历
                // 找到0所在的位置
                int index = cur.indexOf("0");
                for (int j : next[index]) {
                    String str = swap(cur, index, j);
                    if(!set.contains(str)) {
                        queue.offer(str);
                        set.add(str);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
