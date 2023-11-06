import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();    
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            arrayList.add(d);
            for (int ii = 0; ii < d; ii++) {
                int dd = sc.nextInt();
                arrayList.add(dd);
            }
        }
        int q = sc.nextInt(); 
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int chiso = 0;
            for (int ii = 0; ii < n; ii++) {  // đang xét dòng thứ ii 
                int d = arrayList.get(chiso);
                if (ii + 1 == x) {
                    if (d < y) {
                        System.out.println("ERROR!");
                        } else {
                            System.out.println(arrayList.get(chiso + y));
                        }
                    break;
                } else {
                    chiso += d;
                    chiso += 1;
                }                
            }
        }
    }
}
