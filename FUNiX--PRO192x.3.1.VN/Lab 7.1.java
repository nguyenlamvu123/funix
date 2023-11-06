import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mang = new int[10];
		for (int m: mang) {
			int songuyen = sc.nextInt();
			System.out.print(songuyen + " ");
		}
	}
}

