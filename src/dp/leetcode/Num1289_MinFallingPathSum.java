package dp.leetcode;

public class Num1289_MinFallingPathSum {
    // 优化
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int j1 = -1;
        int j2 = -1;
        // 找到第一行的最小值和次小值下标
        for (int i = 0; i < n; i++) {
            int val = grid[0][i];
            if(val < (j1 == -1 ? Integer.MAX_VALUE : grid[0][j1])) {
                j2 = j1;
                j1 = i;
            }else if(val < (j2 == -1 ? Integer.MAX_VALUE : grid[0][j2])) {
                j2 = i;
            }
        }

        for (int i = 1; i < n; i++) {
            // 建立用于暂时保存该行的最小值和次小值下标的临时变量
            int t1 = -1;
            int t2 = -1;
            for (int j = 0; j < n; j++) {
                //状态转移
                if(j != j1) {
                    grid[i][j] += grid[i - 1][j1];
                }else {
                    grid[i][j] += grid[i - 1][j2];
                }
                // 更新当前行的最小值和次小值
                if(grid[i][j] < (t1 == -1 ? Integer.MAX_VALUE : grid[i][t1])) {
                    t2 = t1;
                    t1 = j;
                }else if(grid[i][j] < (t2 == -1 ? Integer.MAX_VALUE : grid[i][t2])) {
                    t2 = j;
                }
            }
            j1 = t1;
            j2 = t2;
        }
        int min = grid[n - 1][0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, grid[n - 1][i]);
        }
        return min;
    }

//    public int minFallingPathSum(int[][] grid) {
//        int n = grid.length;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int min = Integer.MAX_VALUE;
//                for (int k = 0; k < n; k++) {
//                    if(k != j) {
//                        min = Math.min(min, grid[i - 1][k]);
//                    }
//                }
//                grid[i][j] = min + grid[i][j];
//            }
//        }
//        int min = grid[n - 1][0];
//        for (int i = 1; i < n; i++) {
//            min = Math.min(min, grid[n - 1][i]);
//        }
//        return min;
//    }
}
