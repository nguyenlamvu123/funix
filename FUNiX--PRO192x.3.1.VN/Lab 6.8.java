import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int mu = 1;
		for (int i = 0; i < b; i++) {
			mu *= a;
		}
		System.out.print(mu);
	}
}
