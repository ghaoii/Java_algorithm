package backtracking.bfs.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Num429_LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                curRes.add(node.val);
                if(node.children != null) {
                    for(Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            ret.add(curRes);
        }
        return ret;
    }
}
