import java.util.*;
public class Main {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> linkedlist = new LinkedList<>();
        int n = scan.nextInt();
        for (int i = n; i >= 1; i--){
            linkedlist.offer(i);
        }
        for (int i = 2; i <= n; i++){
            linkedlist.offer(i);
        }
        scan.close();
        linkedlist.forEach(i -> System.out.print(i + " "));
    }
}