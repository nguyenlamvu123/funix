import java.util.*;
class Solution{
    public static boolean check(String input){

        Stack<Character> stk = new Stack<>();
        String str = "})]";
        int i = 0;       

        while(i < input.length())
        {
            Character ch = input.charAt(i);

            if(!str.contains(ch.toString()))
                stk.push(ch);

            else{
                switch(ch){
                case '}':
                    if(stk.isEmpty() || stk.pop() != '{')
                        return false;
                    break;               

                case ')':
                    if(stk.isEmpty() || stk.pop() != '(')
                        return false;
                    break;
                case ']':
                    if(stk.isEmpty() || stk.pop() != '[')
                        return false;
                    break;
                }
            }                                        
            i++;
        }        

        if(stk.isEmpty())
            return true;

        return false;
    }

    public static void main(String []argh){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            boolean val = check(input);
            System.out.println(val);
        }
    }
}