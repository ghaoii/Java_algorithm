package dp.leetcode;

public class Num63_NniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] pNum = new int[rows][cols];
        // 初始化f[0][0] = 1;
        pNum[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        // 状态转移方程
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(obstacleGrid[i][j] != 1) {
                    if(i > 0 && j > 0) {
                        pNum[i][j] = pNum[i - 1][j] + pNum[i][j - 1];
                    }else if(i > 0) {
                        // 第一列
                        pNum[i][j] = pNum[i - 1][j];
                    }else if(j > 0) {
                        // 第一行
                        pNum[i][j] = pNum[i][j -1];
                    }
                }
            }
        }
        return pNum[rows - 1][cols - 1];
    }
}
