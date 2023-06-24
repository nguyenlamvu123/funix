import java.util.Scanner;

public class Method {
	public static void show(String[] arr) {
		String strdainhat = "";
		int dainhat = 0;
		for (int i  = 0; i < arr.length; i++) {
			// if (arr[i].length() > dainhat) {
			// 	dainhat = arr[i].length();
			// 	strdainhat = arr[i];
			if (arr[i].length() > 3) {
				strdainhat += arr[i];
				strdainhat += ' ';
			}
		}
		System.out.println(strdainhat);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		show(arr);
	}
}
