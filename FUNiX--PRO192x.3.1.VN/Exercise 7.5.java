import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int soluongmangconcotongam = 0;
        int dongthuhai[] = new int[n];
        for (int i = 0; i < n; i++) {
            dongthuhai[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int tong = 0;
            for (int j = i; j < n; j++) {                    
                tong += dongthuhai[j];
                if (tong < 0) {
                    soluongmangconcotongam += 1;
                }
            }
        }
        System.out.println(soluongmangconcotongam);
    }
}
