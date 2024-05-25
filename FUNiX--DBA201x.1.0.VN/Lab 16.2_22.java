import java.util.*;
public class Main {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> linkedlist = new LinkedList<Integer>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            linkedlist.offer(scan.nextInt());
        }

	    int x = scan.nextInt();
	    int k = scan.nextInt();
        scan.close();

	    linkedlist.add(x, k);
        for (int j : linkedlist){
            System.out.print(j + " ");
        }
    }
}