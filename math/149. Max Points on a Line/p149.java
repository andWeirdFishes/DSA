class Point {
    public double x;
    public double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double a, double b) {
        x = a;
        y = b;
    }
}

class p149 {
    // Either return the values or use an array/object to hold m and c
    public double[] line(Point p1, Point p2) {
        double m = (p1.y - p2.y) / (p1.x - p2.x);
        double c = p1.y - m * p1.x;
        return new double[] { m, c };
    }

    public int maxPoints(int[][] P) {
        if (P.length <= 2)
            return P.length; // Handle edge cases

        Point[] p = new Point[P.length];
        for (int i = 0; i < P.length; i++) {
            p[i] = new Point((double) P[i][0], (double) P[i][1]);
        }

        int maxCount = 2;
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                int count = 2;
                if (p[i].x == p[j].x) {
                    double va = p[i].x;
                    for (int z = 0; z < p.length; z++) {
                        if (z == i || z == j)
                            continue;
                        if (p[z].x == va)
                            count++;
                    }
                } else {
                    double[] lineParams = line(p[i], p[j]);
                    double m = lineParams[0];
                    double c = lineParams[1];
                    for (int z = 0; z < p.length; z++) {
                        if (z == i || z == j)
                            continue;
                        if (Math.abs(p[z].y - (m * p[z].x + c)) < 1e-10)
                            count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}