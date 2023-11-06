import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tong = 0;
		int[] mangcacsonguyen = new int[n];
		for (int phant_u: mangcacsonguyen) {
			int phantu = sc.nextInt();
			if (phantu > 0 && phantu % 2 == 1) {
				tong += phantu;
			}
			}
		System.out.print(tong);
	}
}

