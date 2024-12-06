import java.util.Scanner;
import java.util.Arrays;

public class MaxAdRevenue {

    private static long maxRevenue(int[] profits, int[] clicks) {
        Arrays.sort(profits);
        Arrays.sort(clicks);
        long maxRevenue = 0;
        
        for (int i = 0; i < profits.length; i++) {
            maxRevenue += (long) profits[i] * clicks[i];
        }
        
        return maxRevenue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] profits = new int[n];
        int[] clicks = new int[n];

        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            clicks[i] = scanner.nextInt();
        }

        System.out.println(maxRevenue(profits, clicks));
    }
}
