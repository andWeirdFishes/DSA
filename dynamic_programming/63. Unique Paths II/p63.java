public class p63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        int[][] num = new int[R][C];
        num[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < R; i++)
            num[i][0] = num[i - 1][0] * (1 - obstacleGrid[i][0]);
        for (int j = 1; j < C; j++)
            num[0][j] = num[0][j - 1] * (1 - obstacleGrid[0][j]);
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 1 || (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1))
                    num[i][j] = 0;
                else if (obstacleGrid[i - 1][j] == 1)
                    num[i][j] = num[i][j - 1];
                else if (obstacleGrid[i][j - 1] == 1)
                    num[i][j] = num[i - 1][j];
                else
                    num[i][j] = num[i - 1][j] + num[i][j - 1];
            }
        }
        return num[R - 1][C - 1];
    }
}
