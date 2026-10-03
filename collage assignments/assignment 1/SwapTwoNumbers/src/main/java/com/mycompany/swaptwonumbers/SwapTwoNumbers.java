package com.mycompany.swaptwonumbers;
import java.util.Scanner;
public class SwapTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
    
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a equals " + a + "\nb equals " + b);
    }
}
