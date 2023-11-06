class ArrayCalculator {
    public int maxOfArray(int[] arr) {
        int ret = arr[0];
        for (int i=1; i < arr.length; i++) {
            if (arr[i] > ret) {
                ret = arr[i];
            }
        }
        return ret;
    }

    public double maxOfArray(double[] arr) {
        double ret = arr[0];
        for (int i=1; i < arr.length; i++) {
            if (arr[i] > ret) {
                ret = arr[i];
            }
        }
        return ret;
    }

    public int minOfArray(int[] arr) {
        int ret = arr[0];
        for (int i=1; i < arr.length; i++) {
            if |(arr[i] < ret) {
                ret = arr[i];
            }
        }
        return ret;
    }

    public double minOfArray(double[] arr) {
        double ret = arr[0];
        for (int i=1; i < arr.length; i++) {
            if (arr[i] < ret) {
                ret = arr[i];
            }
        }
        return ret;
    }
}
