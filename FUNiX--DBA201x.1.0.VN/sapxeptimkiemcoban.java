import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;


public class Array {
	public static void main(String[] args) {
    try {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		FileWriter myWriter = new FileWriter("INPUT.TXT");
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			myWriter.write(x);
		}
		myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	}
}

