public class p45 {
    public int jump(int[] nums) {
        int n = nums.length;
        // min[i] = min # of jumps needed from i-th place
        int[] min = new int[n];

        for (int i = 0; i < n; i++) {
            min[i] = 2147483646;
        }

        min[n - 1] = 0;

        for (int j = n - 2; j >= 0; j--) {
            if (nums[j] >= n - j - 1) {
                min[j] = 1;
            } else if (nums[j] > 0) {
                int mn = 2147483646;
                for (int i = j + 1; i < n && i <= nums[j] + j; i++) {
                    mn = Math.min(mn, min[i]);
                }
                min[j] = 1 + mn;
            }
        }

        return min[0];
    }
}
