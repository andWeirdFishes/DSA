public class p115 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // Edge case: If target string `t` is longer than `s`, no subsequence can match
        if (n > m)
            return 0;

        // DP table with (m + 1) x (n + 1) dimensions
        int[][] dp = new int[m + 1][n + 1];

        // Initialization: dp[i][0] = 1 for all i
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, consider both including and excluding s[i-1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Otherwise, exclude s[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result is in dp[m][n]
        return dp[m][n];
    }
}
