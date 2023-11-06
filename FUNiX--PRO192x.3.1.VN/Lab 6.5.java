import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 1;
		String tong = "";
		for (int i = a; i > 1; i--) {
			b *= i;
		}
		System.out.println(b);
	}
}
