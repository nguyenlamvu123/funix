import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sophantucogiatribangk = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();

		for (int i = 0; i < n; i++) {
			if (arr[i] == k) {
				sophantucogiatribangk += 1;
			}
		}
		System.out.print(sophantucogiatribangk);
	}
}

