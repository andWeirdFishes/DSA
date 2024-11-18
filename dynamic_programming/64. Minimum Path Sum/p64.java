public class p64 {
    public int minPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        for (int i = 1; i < R; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < C; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[R - 1][C - 1];
    }
}
