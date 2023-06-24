import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		s1 = s1.toUpperCase();
		s2 = s2.toUpperCase();
		System.out.println(s1.indexOf(s2));
	}
}
