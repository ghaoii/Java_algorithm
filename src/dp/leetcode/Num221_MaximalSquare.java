package dp.leetcode;

public class Num221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 初始化为f(i,0) = f(0,i) = 0，创建好二维数组就已经初始化了
        int[][] maxS = new int[row + 1][col + 1];
        //状态转移方程f(i,j) = min(f(i-1,j), f(i,j-1), f(i-1,j-1)) + 1;
        int maxSize = 0;// 用于记录出现过的最大边长
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    maxS[i][j] = Math.min(Math.min(maxS[i][j - 1], maxS[i - 1][j]), maxS[i - 1][j - 1]) + 1;
                    maxSize = Math.max(maxSize, maxS[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }
}
