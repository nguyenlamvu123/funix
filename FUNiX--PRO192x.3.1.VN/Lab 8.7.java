class Math {
    double PI = 3.14;
    public int abs(int x) {
        if (x > 0) {
            return x;
        } else {
            return -x;
        }
        }
    public int add(int x, int y) {
        return y + x;
    }
    public int subtract(int x, int y) {
        return x - y;
    }
    public int min(int x, int y) {
        if (x > y) {
            return y;
        } else {
            return x;
        }
    }
    public int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
    public int pow(int x, int y) {
        int z = 1;
        for (int yy = 0; yy < y; yy++) {
            z *= x;
        }
        return z;
    }
}
