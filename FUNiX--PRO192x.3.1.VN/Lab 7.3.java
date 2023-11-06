import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int tong = 0;
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if (i == 0 || i == n-1) {
				tong += arr[i];
			}
		}
		System.out.print(tong);
	}
}

