import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        

        Locale usLocale = new Locale("en", "US"); 
        Locale indiLocale = new Locale("en", "IN");
        Locale chiLocale = new Locale("zh", "CN");
        Locale frLocale = new Locale("fr", "FR");

        NumberFormat usFormat = NumberFormat.getCurrencyInstance(usLocale);
        NumberFormat indiFormat = NumberFormat.getCurrencyInstance(indiLocale);
        NumberFormat chiFormat = NumberFormat.getCurrencyInstance(chiLocale);
        NumberFormat frFormat = NumberFormat.getCurrencyInstance(frLocale);

        String us = usFormat.format(payment);
        String india  = indiFormat.format(payment);
        String china = chiFormat.format(payment);
        String france = frFormat.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}