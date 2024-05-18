import java.io.*;
import java.util.Scanner;


public class Array {
	public static void main(String[] args) {
		luuvaotep();
		docfile();
	}

	public static void luuvaotep() {
		try {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			FileWriter out = new FileWriter("INPUT.TXT");
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				out.write(x);
			}
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void docfile() {
		try {
			FileReader in = new FileReader("INPUT.TXT");
			int [] mang1chieu = new int[20];
			int c;
			while ((c = in.read()) != -1) {
				System.out.println(c);
			}
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}