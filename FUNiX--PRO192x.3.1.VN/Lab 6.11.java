public class Loop {
	public static void main(String[] args) {
	    int i = 1;
	    do {
	        if (i % 10 == 0) {
				System.out.print(i + " ");
				i += 10;
			} else {
				i++;
			}
	    } while (i <= 1000);
	}
}
