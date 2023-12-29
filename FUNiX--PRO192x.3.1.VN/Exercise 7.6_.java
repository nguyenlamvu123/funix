import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();    
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int d = sc.nextInt();
            arrayList.add(d);
            for (int ii = 0; ii < d; ii++) {
                int dd = sc.nextInt();
                arrayList.add(dd);
            }
            mainList.add(arrayList);
        }
        int q = sc.nextInt(); 
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x <= mainList.size()) {
                List<Integer> linexth = mainList.get(x - 1);
                if (y < linexth.size()) {
                    System.out.println(linexth.get(y));
                    continue;
                }
            System.out.println("ERROR!");
            }
        }
    }
}
