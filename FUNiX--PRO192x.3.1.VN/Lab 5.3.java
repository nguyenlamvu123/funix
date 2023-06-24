import java.util.Scanner;

public class Method {
	public static int max3(int a, int b, int c) {
		int m = c;
		if (a >= b && a >= c) {
			m = a;
		}
		else if (b > c) {
			m = b;
		}
		return m;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		System.out.print(max3(a, b, c));
	}
}
