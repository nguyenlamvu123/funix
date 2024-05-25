import java.util.*;
public class Main {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> linkedlist = new LinkedList<Integer>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            linkedlist.offer(scan.nextInt());
        }

	    int k = scan.nextInt();
        scan.close();
        for (int i = k; i < n; i++){
            System.out.print(linkedlist.get(i) + " ");
        }
        for (int i = 0; i < k; i++){
            System.out.print(linkedlist.get(i) + " ");
        }
    }
}