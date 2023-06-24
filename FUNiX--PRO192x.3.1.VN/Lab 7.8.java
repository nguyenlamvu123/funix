import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tamthoi = 0;
		int[] mangcacsonguyen = new int[n];
		for (int i = 0; i < n; i++) {
			mangcacsonguyen[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (mangcacsonguyen[i] > mangcacsonguyen[j]) {
					tamthoi = mangcacsonguyen[i];
					mangcacsonguyen[i] = mangcacsonguyen[j];
					mangcacsonguyen[j] = tamthoi;
				}
			}
		}
		for (int songuyen_: mangcacsonguyen) {
			System.out.print(songuyen_ + " ");
		}
	}
}
