package dp.leetcode;

public class Num931_MinFallingPathSum {
    // 复习
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        //int[][] minP = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
//                matrix[i][j] = matrix[i - 1][j] + val;
//                if(j != 0) {
//                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j - 1] + val);
//                }
//                if( j != n - 1) {
//                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j + 1] + val);
//                }

                if(j == 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]) + val;
                }else if(j == n - 1) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]) + val;
                }else {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i - 1][j + 1]) + val;
                }
            }
        }
        int min = matrix[n - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, matrix[n - 1][i]);
        }
        return min;
    }


//    public int minFallingPathSum(int[][] matrix) {
//        // 状态f(i,j):从第一层下降到[i][j]的最小和
//        int len = matrix.length;
//        int[][] minF = new int[len + 1][len + 1];
//        // 初始化f(0,j) = 0, f(i,0) = MAX;
//        for (int i = 1; i <= len; i++) {
//            minF[i][0] = Integer.MAX_VALUE;
//        }
//        // 状态转移方程f(i,j) = min(f(i - 1, j - 1),f(i - 1, j),f(i - 1, j + 1)) + matrix[i - 1][j - 1];
//        // if(j == 0),f(i,j) =
//        for (int i = 1; i <= len; i++) {
//            for (int j = 1; j <= len; j++) {
//                if(j == len) {
//                    minF[i][j] = Math.min(minF[i - 1][j - 1], minF[i - 1][j]) + matrix[i - 1][j - 1];
//                }else {
//                    int temp = Math.min(minF[i - 1][j - 1], minF[i - 1][j]);
//                    temp = Math.min(temp, minF[i - 1][j + 1]);
//                    minF[i][j] = temp + matrix[i - 1][j - 1];
//                }
//            }
//        }
//        //遍历最后一行，返回最小值
//        int min = minF[len][0];
//        for (int i = 1; i <= len; i++) {
//            if(minF[len][i] < min) {
//                min = minF[len][i];
//            }
//        }
//        return min;
//    }
}

// 递归解法超出时间限制
//public class Num931_MinFallingPathSum {
//    public int minFallingPathSum(int[][] matrix) {
//        int len = matrix.length;
//        // 由于matrix中的最大值为100，长度最大也为100，所以下降路径和不可能超过10000
//        // 这里的10001就相当于无穷大
//        int min = 10001;
//        for (int i = 0; i < len; i++) {
//            min = Math.min(min, helper(matrix, len - 1, i));
//        }
//        return min;
//    }
//
//    //递归解决，传入二维数组，就能算出从顶层到mareix[row][col]下降路径的最小和
//    private int helper(int[][] matrix, int row, int col) {
//        if(col < 0 || col >= matrix.length) {
//            return 1000;
//        }
//        if(row == 0) {
//            return matrix[row][col];
//        }
//        int minD = 1000;
//        minD = Math.min(helper(matrix, row - 1, col- 1), helper(matrix, row - 1, col));
//        minD = Math.min(minD, helper(matrix, row - 1, col + 1));
//        return minD + matrix[row][col];
//    }
//}
