public class p1524 {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        long oddCount = 0;
        long evenCount = 1; // Initialize with 1 to count the empty prefix
        long currentSum = 0;
        long result = 0;

        for (int num : arr) {
            currentSum += num;

            // Check if current cumulative sum is odd or even
            if (currentSum % 2 == 0) {
                // Add oddCount subarrays (since they make new odd sums)
                result += oddCount;
                evenCount++; // Increment even count
            } else {
                result += evenCount;
                oddCount++;
            }
            result %= MOD;
        }

        return (int) result;
    }

}
