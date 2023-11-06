import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ret = "";
		for (int i = n; i >= -n; i--) {
			ret = ret + i + " ";
		}
		System.out.println(ret);
	}
}
