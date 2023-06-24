import java.util.Scanner;

public class Array {
	public static int[] getIntegers(int capacity) {
		int[] array = new int[capacity];
		for (int i = 0; i < capacity; i++) {
			array[i] = sc.nextInt();
		}
		return array;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		int tong = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] % 5 == 0) {
					tong += arr[i][j];
				}
			}
		}
		System.out.print(tong);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < arrray.length; i++) {
			System.out.print(array[i]);
		}
	}
}
