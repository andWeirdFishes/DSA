class p172 {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        int count = 0;
        for (int i = 1; Math.pow(5, i) <= n; i++) {
            count += n / Math.pow(5, i);
        }
        return count;
    }
}