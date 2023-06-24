import java.util.Scanner;

public class Method {
	public static void show(int[] arr) {
		String strdainhat = "";
		int dainhat = 0;
		for (int i  = 0; i < arr.length; i++) {
			if (arr[i] % 3 == 0 && arr[i] % 5 != 0) {
				strdainhat += arr[i];
				strdainhat += ' ';
			}
		}
		System.out.println(strdainhat);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		show(arr);
	}
}
