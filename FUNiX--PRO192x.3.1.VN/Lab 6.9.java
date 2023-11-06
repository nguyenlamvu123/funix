import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String tong = "";
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				tong += i;
				tong += " ";
			}			
		}
		System.out.println(tong);
	}
}
