package dp.nowcoder;

public class CC77_MinDistance {
    public int minDistance (String word1, String word2) {
        int row = word1.length();
        int col = word2.length();
        int[][] minD = new int[row + 1][col + 1];
        //初始化
        for (int i = 0; i <= col; i++) {
            minD[0][i] = i;
        }
        for (int i = 1; i <= row; i++) {
            minD[i][0] = i;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                //插入和删除
                minD[i][j] = Math.min(minD[i][j - 1], minD[i - 1][j]) + 1;
                //替换
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    //如果连个字符相同则不需要替换
                    minD[i][j] = Math.min(minD[i][j], minD[i - 1][j - 1]);
                }else{
                    minD[i][j] = Math.min(minD[i][j], minD[i - 1][j - 1] + 1);
                }
            }
        }
        return minD[row][col];
    }
}
