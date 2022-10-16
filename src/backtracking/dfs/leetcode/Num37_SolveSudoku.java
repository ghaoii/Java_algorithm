package backtracking.dfs.leetcode;

public class Num37_SolveSudoku {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int i, int j) {
        // 如果所有行都填完了，说明找到了可行解，返回true
        if(i == 9) {
            return true;
        }
        // 如果当前行已经填完了，就从下一行的第一列开始填
        if(j == 9) {
            return solveSudoku(board, i + 1, 0);
        }
        // 当该位置已经填了数字，那么跳过继续填下一个
        if(board[i][j] != '.') {
            if(solveSudoku(board, i, j + 1)) {
                return true;
            }
            return false;
        }
        // 当前位置没有填数字，则从遍历1-9
        for (char k = '1'; k <= '9'; k++) {
            if(!isValid(board, i, j, k)) {
                continue;
            }
            // 做出选择
            board[i][j] = k;
            // 深度递归，如果找到可行解，返回true
            if(solveSudoku(board, i, j + 1)) {
                return true;
            }
        }
        // 撤销选择，否则下一次走到这里的时候就直接跳过了
        board[i][j] = '.';
        // 如果遍历完所有的数字都没有找到可行解，则返回false
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char k) {
        for(int a = 0; a < 9; a++) {
            // 判断行中k是否唯一
            if(board[i][a] == k) {
                return false;
            }
            // 判断列中k是否唯一
            if(board[a][j] == k) {
                return false;
            }
            // 判断3*3的方格中k是否唯一
            if(board[(i/3)*3 + a/3][(j/3)*3 + a%3] == k) {
                return false;
            }
        }
        return true;
    }
}
