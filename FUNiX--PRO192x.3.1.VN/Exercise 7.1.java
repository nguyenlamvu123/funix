import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        a= a.toLowerCase();
        b=b.toLowerCase();
        
        if(a.length()!=b.length())
            return false;
        
        char[] arrA1 = a.toCharArray();
        char[] arrB1 = b.toCharArray();
        System.out.println(arrA1);
        System.out.println(arrB1);
        
        java.util.Arrays.sort(arrA1);
        java.util.Arrays.sort(arrB1);
        
        return java.util.Arrays.equals(arrA1, arrB1);
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

