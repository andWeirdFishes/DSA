public class p300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int currMax = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            currMax = Math.max(dp[i], currMax);
        }
        return currMax;
    }
}
