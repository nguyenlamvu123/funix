import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int samgiongzon = sc.nextInt();
		if (samgiongzon % 2 == 0) {
			System.out.println("n is an even number");
		} else {
			System.out.println("n is an odd number");
		};
	}
}