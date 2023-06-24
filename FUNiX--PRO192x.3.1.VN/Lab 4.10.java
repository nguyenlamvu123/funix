import java.util.Scanner;

public class Statement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sam = sc.next();
		String zon = sc.next();
		if (sam.equals(zon)) {
			System.out.println("two people have the same name");
		} else {
			System.out.println("two people don't have the same name");
		}
	}
}
