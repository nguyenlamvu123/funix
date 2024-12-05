import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CollectSignatures {

    private static int[] optimalPoints(int[][] segments) {
        Arrays.sort(segments, Comparator.comparingInt(a -> a[1]));
        int[] points = new int[segments.length];
        int count = 0;

        int currentPoint = segments[0][1];
        points[count++] = currentPoint;

        for (int i = 1; i < segments.length; i++) {
            if (segments[i][0] > currentPoint) {
                currentPoint = segments[i][1];
                points[count++] = currentPoint;
            }
        }

        return Arrays.copyOf(points, count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] segments = new int[n][2];

        for (int i = 0; i < n; i++) {
            segments[i][0] = scanner.nextInt();
            segments[i][1] = scanner.nextInt();
        }

        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
