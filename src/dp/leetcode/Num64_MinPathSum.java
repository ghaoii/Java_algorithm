package dp.leetcode;

public class Num64_MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minP = new int[m][n];
        // 初始化
//        minP[0][0] = grid[0][0];
        // 状态转移
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if(i == 0 && j == 0) {
//                    minP[i][j] = grid[i][j];
//                }else {
//                    int top = i > 0 ? minP[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
//                    int left = j > 0 ? minP[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
//                    minP[i][j] = Math.min(top, left);
//                }

                if(i > 0 && j > 0) {
                    minP[i][j] = Math.min(minP[i - 1][j], minP[i][j - 1]) + grid[i][j];
                }else if (i > 0) {
                    // 第一列
                    minP[i][j] = minP[i - 1][j] + grid[i][j];
                }else if (j > 0) {
                    minP[i][j] = minP[i][j - 1] + grid[i][j];
                }
            }
        }
        return minP[m - 1][n - 1];
    }
}
