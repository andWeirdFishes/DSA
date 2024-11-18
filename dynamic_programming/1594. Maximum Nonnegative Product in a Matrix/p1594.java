public class p1594 {
    public int maxProductPath(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        long[][] dpMax = new long[R][C];
        long[][] dpMin = new long[R][C];
        long mod = 1000000007;

        dpMax[0][0] = grid[0][0];
        dpMin[0][0] = grid[0][0];

        for (int i = 1; i < R; i++) {
            dpMax[i][0] = (dpMax[i - 1][0] * grid[i][0]);
            dpMin[i][0] = dpMax[i][0];
        }

        for (int j = 1; j < C; j++) {
            dpMax[0][j] = (dpMax[0][j - 1] * grid[0][j]);
            dpMin[0][j] = dpMax[0][j];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                long a = (dpMax[i][j - 1] * grid[i][j]);
                long b = (dpMax[i - 1][j] * grid[i][j]);
                long c = (dpMin[i][j - 1] * grid[i][j]);
                long d = (dpMin[i - 1][j] * grid[i][j]);

                dpMax[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                dpMin[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        return dpMax[R - 1][C - 1] >= 0 ? (int) (dpMax[R - 1][C - 1] % mod) : -1;
    }

}
