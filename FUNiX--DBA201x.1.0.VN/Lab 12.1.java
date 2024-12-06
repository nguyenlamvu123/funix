import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
	int n = 0;
	int[] tienle = {10, 5, 1};
	int m_ = m;
        for (int menhgia: tienle) {
		n += m_ / menhgia;
		m_ = m_ % menhgia;
	}
        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

