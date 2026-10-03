package com.mycompany.countdigitsinteger;
import java.util.Scanner;

public class CountDigitsInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int integer = scanner.nextInt(); 
        int count = 0;
        
            if(integer < 0) integer = Math.abs(integer); // to make it positive 
            if(integer == 0) count = 1;
                else {while(integer > 0){
                             count++;
                             integer /= 10;
                }
            }
        System.out.println("The total number of digits is " + count);
    }
}
