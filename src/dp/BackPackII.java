package dp;

import com.sun.xml.internal.ws.encoding.MtomCodec;

public class BackPackII {
    //优化写法
    public int backPackII(int m, int[] a, int[] v) {
        int n = a.length;
        int[] maxVal = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                if(a[i - 1] <= j){
                    maxVal[j] = Math.max(maxVal[j - a[i - 1]] + v[i - 1], maxVal[j]);
                }
            }
        }
        return maxVal[m];
    }


    //未优化
//    public int backPackII(int m, int[] a, int[] v) {
//        int n = a.length;
//        int[][] totalVal = new int[n + 1][m + 1];
//        //初始化
//        for (int i = 0; i <= m; i++) {
//            totalVal[0][i] = 0;
//        }
//        for (int i = 1; i <= n; i++) {
//            totalVal[i][0] = 0;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if(a[i - 1] <= j){
//                    totalVal[i][j] = Math.max(totalVal[i - 1][j - a[i - 1]] + v[i - 1], totalVal[i - 1][j]);
//                }else{
//                    totalVal[i][j] = totalVal[i - 1][j];
//                }
//            }
//        }
//        return totalVal[n][m];
//    }
}

