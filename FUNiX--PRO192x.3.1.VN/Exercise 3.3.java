import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger first = new BigInteger(sc.next());
        BigInteger second = new BigInteger(sc.next());
        System.out.println(first.add(second));
        System.out.println(first.multiply(second));
   }
}
