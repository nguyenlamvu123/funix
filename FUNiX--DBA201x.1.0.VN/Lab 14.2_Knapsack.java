import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int[][] dp = new int[w.length + 1][W + 1];

        for (int i = 1; i <= w.length; i++) {
            for (int weight = 1; weight <= W; weight++) {
                dp[i][weight] = dp[i - 1][weight];
                if (w[i - 1] <= weight) {
                    dp[i][weight] = Math.max(dp[i][weight], dp[i - 1][weight - w[i - 1]] + w[i - 1]);
                }
            }
        }

        return dp[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
        scanner.close();
    }
}
