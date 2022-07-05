package backtracking.bfs;

import java.util.Deque;
import java.util.LinkedList;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BFSTest {
    // 传入一个迷宫矩阵，矩阵中1为障碍物，0为空
    public static boolean bfs(int[][] mat, int startX, int startY, int destX, int destY) {
        // 使用队列保存搜索到的位置
        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startX, startY));

        int row = mat.length;
        int col = mat[0].length;

        int[][] book = new int[row][col];
        book[startX][startY] = 1;

        int[][] nextP = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            // 如果当前位置终点了，则返回true；
            if (pair.x == destX && pair.y == destY) {
                return true;
            }
            // 搜索新的位置
            for (int i = 0; i < 4; i++) {
                int newX = pair.x + nextP[i][0];
                int newY = pair.y + nextP[i][1];
                // 如果位置不合法就跳过
                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }
                // 如果该位置还没有走过且没有障碍物，就添加
                if (mat[newX][newY] == 0 || book[newX][newY] == 0) {
                    queue.offer(new Pair(newX, newY));
                    book[pair.x][pair.y] = 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1, 0}, {1, 0, 0, 1}, {0, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(bfs(mat, 0, 0, 3, 3));
    }
}
