package backtracking.dfs.leetcode;

public class Num733_FloodFill {
    // 分别对应上下左右的x和y
    int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] image, int[][] book, int x, int y, int oldColor, int newColor) {
        // 先把当前位置的颜色修改掉
        image[x][y] = newColor;
        book[x][y] = 1;
        // 深度遍历四周元素
        for (int i = 0; i < 4; i++) {
            int newX = x + pos[i][0];
            int newY = y + pos[i][1];
            if(newX < 0 || newX >= image.length || newY < 0 || newY >= image[0].length) {
                continue;
            }
            if(image[newX][newY] == oldColor && book[newX][newY] == 0) {
                dfs(image, book, newX, newY, oldColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        int[][] book = new int[row][col];
        int oldColor = image[sr][sc];
        dfs(image, book, sr, sc, oldColor, color);
        return image;
    }
}
