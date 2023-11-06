import java.io.*;
import java.util.*;

public class Solution {

    public static String viethoachucaidautien(String name) {
        String firstLetter = name.substring(0, 1);
        String therest = name.substring(1, name.length());
        return firstLetter.toUpperCase() + therest;
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length() + B.length());
        if (A.compareTo(B) <= 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        System.out.println(viethoachucaidautien(A) + " " + viethoachucaidautien(B));
        
        
    }
}




