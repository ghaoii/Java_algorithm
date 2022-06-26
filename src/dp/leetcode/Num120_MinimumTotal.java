package dp.leetcode;

import java.util.List;

public class Num120_MinimumTotal {
    // 自底向上
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int temp = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, temp + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    // 优化
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int len = triangle.size();
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j <= i; j++) {
//                int temp = 0;
//                int val = triangle.get(i).get(j);
//                if(j == 0) {
//                    temp = triangle.get(i - 1).get(j);
//                }else if(j == i) {
//                    temp = triangle.get(i - 1).get(j - 1);
//                }else {
//                    temp = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
//                }
//                triangle.get(i).set(j, temp + val);
//            }
//        }
//        int min = triangle.get(len - 1).get(0);
//        for (int i = 1; i < len; i++) {
//            min = Math.min(min, triangle.get(len - 1).get(i));
//        }
//        return min;
//    }

//    public int minimumTotal(List<List<Integer>> triangle) {
//        int len = triangle.size();
//        int[][] minP = new int[len][len];
//        // 初始化
//        minP[0][0] = triangle.get(0).get(0);
//        // 状态转移
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j <= i; j++) {
////                int val = triangle.get(i).get(j);
////                minP[i][j] = Integer.MAX_VALUE;
////                if(j != 0) {
////                    minP[i][j] = Math.min(minP[i][j], minP[i - 1][j - 1] + val);
////                }
////                if(j != i) {
////                    minP[i][j] = Math.min(minP[i][j], minP[i - 1][j] + val);
////                }
//
//                int temp = 0;
//                if(j == 0) {
//                    temp = minP[i - 1][j];
//                }else if(j == i) {
//                    temp = minP[i - 1][j - 1];
//                }else {
//                    temp = Math.min(minP[i - 1][j - 1], minP[i - 1][j]);
//                }
//                minP[i][j] = temp + triangle.get(i).get(j);
//            }
//        }
//        int min = minP[len - 1][0];
//        for (int i = 1; i < len; i++) {
//            min = Math.min(min, minP[len - 1][i]);
//        }
//        return min;
//    }
}
