import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> L = new ArrayList<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int l = sc.nextInt();
            L.add(l);
        }
        int Q = sc.nextInt();
        for (int q = 0; q < Q; q++) {
            String InDe = sc.next();
            int ind = sc.nextInt();
            switch (InDe) {                
                case "Insert":
                    int val = sc.nextInt();
                    L.add(ind, val);
                    // if (val < L.size()) {
                    //     L.set(ind, val);
                    // } else {
                    //     L.add(val);
                    // }
                    break;                    
                case "Delete":
                    L.remove(ind);
                    break;
            }
        }
        for (int i = 0; i < L.size(); i++) {
            System.out.print(L.get(i) + " ");
        }        
    }
}

