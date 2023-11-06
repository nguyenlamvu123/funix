import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int demsouoc = sc.nextInt();
		int dem = 1;
		for (int i = 1; i < demsouoc/2 + 1; i++) {
			if (demsouoc % i == 0) {
				dem++;
				}
		}
		System.out.println(dem);
	}
}

