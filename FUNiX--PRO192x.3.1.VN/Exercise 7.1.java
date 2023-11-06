import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        char[] A = a.toLowerCase().toCharArray();
        char[] B = b.toLowerCase().toCharArray();
        if (A.length != B.length) {
            return false;
        }
        java.util.Arrays.sort(A);
        java.util.Arrays.sort(B);
        for (int i=0; i<A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
