import java.io.*;
import java.util.Scanner;


public class Array {
	public static void main(String[] args) {
		luuvaotep();
		int[] mang1chieu = docfile();
		int[] mang1chieu_ = bubbleSort(mang1chieu);
		for (int m: mang1chieu_) {
			System.out.print(m + " ");
		}
	}

	public static void luuvaotep() {
		Scanner sc = new Scanner(System.in);
		try {
			FileWriter out = new FileWriter("INPUT.TXT");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				out.write(x);
			}
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static int[] docfile() {
		int [] mang1chieu = new int[20];
		try {
			FileReader in = new FileReader("INPUT.TXT");
			int c;
			int i = 0;
			while ((c = in.read()) != -1) {
				// System.out.println(c);
				mang1chieu[i] = c;
				i++;
			}
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return mang1chieu;
	}

	public static int[] bubbleSort(int[] arr) {
        	int n = arr.length;
		char[] mangKyTu = new char[arr.length];
	        for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++){
	                	if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			mangKyTu[i] = (char) ('0' + arr[i]);
		}
		try {
			FileWriter out = new FileWriter("INPUT1.TXT");
			out.write(mangKyTu);
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return arr;
        }
}
