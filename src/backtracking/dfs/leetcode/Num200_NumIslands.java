package backtracking.dfs.leetcode;

public class Num200_NumIslands {
    int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 搜索岛屿
    private void dfs(char[][] grid, int x, int y) {
        // 把岛屿改成海洋
        grid[x][y] = '0';
        // 遍历
        for (int i = 0; i < 4; i++) {
            int newX = x + pos[i][0];
            int newY = y + pos[i][1];
            // 判断新坐标的合法性
            if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length)
                continue;
            if(grid[newX][newY] == '1')
                dfs(grid, newX, newY);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
