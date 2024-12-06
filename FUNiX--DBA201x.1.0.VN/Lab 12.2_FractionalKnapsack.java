import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    private static class Item {
        int value;
        int weight;
        double valuePerWeight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = (double) value / weight;
        }
    }

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int n = values.length;
        Item[] items = new Item[n];
        
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        // Sort items by value per unit weight in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> item.valuePerWeight).reversed());

        double totalValue = 0;
        for (Item item : items) {
            if (capacity == 0) break;
            int amount = Math.min(capacity, item.weight);
            totalValue += amount * item.valuePerWeight;
            capacity -= amount;
        }

        return totalValue;
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
        
        System.out.printf("%.4f\n", getOptimalValue(capacity, values, weights));
    }
}
