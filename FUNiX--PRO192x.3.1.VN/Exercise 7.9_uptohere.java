//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;
import java.math.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        Map<String, BigInteger> map=new HashMap<String, BigInteger>();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            BigInteger num=new BigInteger(in.next());
            map.put(name,num);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String cmd=in.nextLine();
            if(map.get(cmd)!=null) System.out.println(cmd+"="+map.get(cmd));
            else System.out.println("Not found");
        }
    }
}

