import java.util.Scanner;

public class Statement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sam = sc.nextInt();
		int giong = sc.nextInt();
		int zon = sc.nextInt();
		if (sam <= giong && giong <= zon) {
			System.out.println("increasing");
			} else if (sam >= giong && giong >= zon) {
			System.out.println("decreasing");
			} else {
			System.out.println("neither increasing nor decreasing order");
			}
	}
}