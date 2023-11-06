import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int calc = a;
            for(int j=0;j<n;j++)
            {
                calc+=(Math.pow(2,j)*b);
                System.out.print(calc+" ");
            }
            System.out.println();
        }
        // in.close();
        // int rut_b_ra = 0;
        // for (int somu = 0; somu < n; somu++) {            
        //     int hailuythua = 1;
        //     for (int haimu = 0; haimu <= somu; haimu++) {
        //         hailuythua *= 2;
        //     }  // 2^(n-1)
        //     rut_b_ra += hailuythua;
        // }  // (2^0+2^1+2^2+...)
        // rut_b_ra *= b;  // (2^0+2^1+2^2+...)*b
        // rut_b_ra += a;  // (2^0+2^1+2^2+...)*b + a
        // System.out.print(rut_b_ra + " ");
    }
}
