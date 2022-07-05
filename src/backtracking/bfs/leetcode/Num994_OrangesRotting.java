package backtracking.bfs.leetcode;


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

public class Num994_OrangesRotting {
    public static void main(String[] args) {
        Num994_OrangesRotting test = new Num994_OrangesRotting();
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println(test.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        Deque<Pair> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        // 先把一开始就坏的橘子放到队列中
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        // 搜索剩下的橘子
        int count = 0;
        int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 要保证确实有橘子被腐烂才能让count++
            // 否则，在最坏的情况下，所有橘子都是坏的，走进循环count也会++
            int flag = 0;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                // 腐蚀其他橘子
                for (int j = 0; j < 4; j++) {
                    int newX = pair.x + nextP[j][0];
                    int newY = pair.y + nextP[j][1];
                    if(newX < 0 || newX >= row || newY < 0 || newY >= col) {
                        continue;
                    }
                    if(grid[newX][newY] == 1) {
                        flag = 1;
                        grid[newX][newY] = 2;
                        queue.offer(new Pair(newX, newY));
                    }
                }
            }
            if(flag == 1) {
                count++;
            }else {
                return count;
            }
        }

        // 再次查看橘子的情况，如果还有没被腐烂的橘子，返回-1，否则返回count
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
