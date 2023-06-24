import java.util.Scanner;

public class Statement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int samgiongzon = sc.nextInt();
		if (samgiongzon < 0 || samgiongzon > 10) {
			System.out.println("The score is not valid");
		} else {
			System.out.println("The score is valid");
		}
	}
}
