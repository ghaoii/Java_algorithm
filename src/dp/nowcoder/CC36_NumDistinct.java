package dp.nowcoder;

public class CC36_NumDistinct {
    //优化
    public int numDistinct (String S, String T) {
        int len = T.length();
        int[] numD = new int[len + 1];
        numD[0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            for (int j = len; j > 0; j--) {
                if(S.charAt(i - 1) == T.charAt(j - 1)) {
                    numD[j] += numD[j - 1];
                }
            }
        }
        return numD[len];
    }

    //未优化
//    public int numDistinct (String S, String T) {
//        int row = S.length();
//        int col = T.length();
//        int[][] numD = new int[row + 1][col + 1];
//        numD[0][0] = 1;
//        for (int i = 1; i <= row; i++) {
//            numD[i][0] = 1;
//            for (int j = 1; j <= col; j++) {
//                if(S.charAt(i - 1) == T.charAt(j - 1)){
//                    numD[i][j] = numD[i - 1][j - 1] + numD[i - 1][j];
//                }else{
//                    numD[i][j] = numD[i - 1][j];
//                }
//            }
//        }
//        return numD[row][col];
//    }
}
