package dp.nowcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CC19_MinCut {
    //优化方法
    public int minCut (String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] minCut = new int[len + 1];
        //初始化
        for (int i = 0; i <= len; i++) {
            minCut[i] = i - 1;
        }
        //前i个字符的最小分割数
        boolean[][] mat = getMat(s);
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if(mat[j][i - 1]){
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[len];
    }

    //优化后的回文串判断
    boolean[][] getMat(String s){
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(i == j) {
                    mat[i][j] = true;
                }else if(i + 1 == j) {
                    mat[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    mat[i][j] = (s.charAt(i) == s.charAt(j)) && mat[i + 1][j - 1];
                }
            }
        }
        return mat;
    }


    //未优化
//    public int minCut (String s) {
//        int len = s.length();
//        if(len == 0){
//            return 0;
//        }
//        if(isPal(s, 0, len - 1)){
//            return 0;
//        }
//        int[] minCut = new int[len + 1];
//        //初始化f(i) = i - 1
//        //优化
//        for (int i = 0; i <= len; i++) {
//            minCut[i] = i - 1;
//        }
//        for (int i = 2; i <= len; i++) {
//            //内层循环从第0个字符开始，这样整体的判断就能放到内层循环了
//            for (int j = 0; j < i; j++) {
//                //判断[j + 1, i]区间的字符串是否为回文串，j + 1个字符对应的索引是j
//                if(isPal(s, j, i - 1)){
//                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
//                }
//            }
//        }
//
//        //未优化
////        for (int i = 1; i <= len; i++) {
////            minCut[i] = i - 1;
////        }
////        for (int i = 2; i <= len; i++) {
////            if(isPal(s, 0, i - 1)){
////                minCut[i] = 0;
////                continue;
////            }
////            //内层循环从第一个字符开始
////            for (int j = 1; j < i; j++) {
////                //判断[j + 1, i]区间的字符串是否为回文串，j + 1个字符对应的索引是j
////                if(isPal(s, j, i - 1)){
////                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
////                }
////            }
////        }
//        return minCut[len];
//    }

    //判断是否为回文串
//    private boolean isPal(String s, int left, int right){
//        while (left < right) {
//            if(s.charAt(left) != s.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
}
