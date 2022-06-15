package dp.leetcode;

public class Num392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int row = s.length();
        int col = t.length();
        boolean[][] has = new boolean[row + 1][col + 1];
        for (int i = 0; i <= col; i++) {
            has[0][i] = true;
        }
        for (int i = 1; i <= row; i++) {
            has[i][0] = false;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    has[i][j] = has[i - 1][j - 1];
                }else{
                    has[i][j] = has[i][j - 1];
                }
            }
        }
        return has[row][col];
    }
}
