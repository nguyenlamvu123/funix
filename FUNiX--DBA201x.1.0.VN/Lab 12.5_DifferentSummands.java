import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistinctSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        List<Integer> result = findLargestDistinctSum(n);
        
        System.out.println("The maximum number of distinct integers that sum up to " + n + " is: " + result.size());
        System.out.println("The integers are: " + result);
        scanner.close();
    }

    public static List<Integer> findLargestDistinctSum(int n) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        int current = 1;

        while (sum + current <= n) {
            result.add(current);
            sum += current;
            current++;
        }

        if (sum < n) {
            int lastIndex = result.size() - 1;
            result.set(lastIndex, result.get(lastIndex) + (n - sum));
        }

        return result;
    }
}
