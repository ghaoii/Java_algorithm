package dp.nowcoder;

public class CC86_MinPathSum {
    public int minPathSum (int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        //第一行
        for (int i = 1; i < col; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        //第一列
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if(i == 0 && j == 0){
//                    continue;
//                }
//                if(i == 0){
//                    grid[i][j] = grid[i][j - 1] + grid[i][j];
//                }else if(j == 0){
//                    grid[i][j] = grid[i - 1][j] + grid[i][j];
//                }else{
//                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
//                }
//            }
//        }
        return grid[row - 1][col - 1];
    }
}
