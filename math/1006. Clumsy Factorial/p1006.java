class p1006 {
    public int clumsy(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 7;
            case 5:
                return 7;
            case 6:
                return 8;
            default:
                int x = n * (n - 1) / (n - 2) + (n - 3);
                x -= 2 * Math.floor((n - 4) * (n - 5) / (n - 6));
                return (x + clumsy(n - 4));
        }
    }
}
