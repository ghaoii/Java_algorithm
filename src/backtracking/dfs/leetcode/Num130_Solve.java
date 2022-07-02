package backtracking.dfs.leetcode;

public class Num130_Solve {
    int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] book = new int[row][col];
        // 遍历第一行和最后一行
        for (int i = 0; i < col; i++) {
            if(board[0][i] == 'O' && book[0][i] == 0)
                dfs(board, book, 0, i);
            if(board[row - 1][i] == 'O' && book[row - 1][i] == 0)
                dfs(board, book, row - 1, i);
        }
        // 遍历第一列和最后一列
        for (int i = 1; i < row - 1; i++) {
            if(board[i][0] == 'O' && book[i][0] == 0)
                dfs(board, book, i, 0);
            if(board[i][col - 1] == 'O' && book[i][col - 1] == 0)
                dfs(board, book, i, col - 1);
        }
        // 遍历矩阵内部
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if(board[i][j] == 'O' && book[i][j] == 0)
                    board[i][j] = 'X';
            }
        }
    }

    // 进入该方法的都是没有包围的'O'
    private void dfs(char[][] board, int[][] book, int x, int y) {
        // 打上标记
        book[x][y] = 1;
        // 对该点深入
        for (int i = 0; i < 4; i++) {
            int newX = x + pos[i][0];
            int newY = y + pos[i][1];

            if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length)
                continue;
            if(board[newX][newY] == 'O' && book[newX][newY] == 0)
                dfs(board, book, newX, newY);
        }
    }
}
