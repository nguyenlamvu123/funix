import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x > 0){ //x duong
            if ( y < 0){ // y am
                System.out.println("This point lies in the Fourth quadrant");
            }
            else { // y duong
                System.out.println("This point lies in the First quadrant");
            }
        }
        else { //x am
            if ( y < 0){ // y am
                System.out.println("This point lies in the Third quadrant");
            }
            else { // y duong
                System.out.println("This point lies in the Second quadrant");
            }
        }
    }
}
