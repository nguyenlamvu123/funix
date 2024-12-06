import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[] operations = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int minOperations = operations[i - 1] + 1;
            if (i % 2 == 0) {
                minOperations = Math.min(minOperations, operations[i / 2] + 1);
            }
            if (i % 3 == 0) {
                minOperations = Math.min(minOperations, operations[i / 3] + 1);
            }
            operations[i] = minOperations;
        }

        List<Integer> sequence = new ArrayList<>();
        for (int i = n; i > 0; ) {
            sequence.add(i);
            if (i % 3 == 0 && operations[i] == operations[i / 3] + 1) {
                i /= 3;
            } else if (i % 2 == 0 && operations[i] == operations[i / 2] + 1) {
                i /= 2;
            } else {
                i -= 1;
            }
        }

        System.out.println(operations[n]);
        for (int i = sequence.size() - 1; i >= 0; i--) {
            System.out.print(sequence.get(i) + " ");
        }
    }
}
