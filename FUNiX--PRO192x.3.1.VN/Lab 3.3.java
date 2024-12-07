import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ten = sc.next();
		int tuoihientai = sc.nextInt();
		System.out.println("In 15 years, age of " + ten + " will be " + (tuoihientai + 15));
	}
}