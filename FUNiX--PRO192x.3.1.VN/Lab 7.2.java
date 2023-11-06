import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int ma_x = 0;
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > ma_x) {
				ma_x = arr[i];
			}
		}
		System.out.print(ma_x);
	}
}

