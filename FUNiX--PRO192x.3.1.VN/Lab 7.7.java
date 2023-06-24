import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] mangcacsonguyen = new int[n];
		for (int songuyen_: mangcacsonguyen) {
			int songuyen = sc.nextInt();
			if (songuyen >= 0 && songuyen <=10) {
				System.out.print(songuyen + " ");
			}
		}
	}
}
