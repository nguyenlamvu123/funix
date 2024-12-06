import java.util.Scanner;
import java.util.Arrays;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
	System.out.println("!!!!!!" + Arrays.toString(values));
	System.out.println(Arrays.toString(weights));
	int n = values.length;
	int i, w;
	int K[][] = new int[n + 1][capacity + 1]; // Build table K[][] in bottom-up manner
	for (i = 0; i <= n; i++) {
		for (w = 0; w <= capacity; w++) {
			// System.out.println("_____" + w);
			if (i == 0 || w == 0)
				K[i][w] = 0;
			else if (weights[i - 1] <= w) {
				// System.out.println("@@@@" + weights[i - 1]);
				// int we_ = w - weights[i - 1];
				// System.out.println("@@@@" + we_);
				K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
			}
			else K[i][w] = K[i - 1][w];
		}
		System.out.println(Arrays.toString(K[i]));
	} // K[n][capacity] holds the maximum value that can be put in a knapsack of capacity W
	return K[n][capacity];
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
