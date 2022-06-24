package dp.leetcode;

public class Num62_UniquePaths {
    // 尝试优化
    public int uniquePaths(int m, int n) {
        int[] pNum = new int[n];
        // 初始化数组为1
        for (int i = 0; i < n; i++) {
            pNum[i] = 1;
        }
        // 第一列都为1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pNum[j] += pNum[j - 1];
            }
        }
        return pNum[n - 1];
    }


//    public int uniquePaths(int m, int n) {
//        int[][] pNum = new int[m][n];
//        // 初始化f[0][j] = 1, f[i][0] = 1
//        for (int i = 0; i < n; i++) {
//            pNum[0][i] = 1;
//        }
//        for (int i = 0; i < m; i++) {
//            pNum[i][0] = 1;
//        }
//        // 状态转移方程
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                pNum[i][j] = pNum[i - 1][j] + pNum[i][j - 1];
//            }
//        }
//        return pNum[m - 1][n - 1];
//    }
}
