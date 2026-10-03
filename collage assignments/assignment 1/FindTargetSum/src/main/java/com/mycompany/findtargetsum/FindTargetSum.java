package com.mycompany.findtargetsum;
import java.util.Scanner;
public class FindTargetSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements:");

        for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
        }

        System.out.print("Enter target: ");
        int target = scanner.nextInt();
        
        int p1 = 0 , p2 = 0;
        
        for(int k = 0 ; k < arr.length ; k++){
            p1 = arr[k];
            for(int j = k + 1 ; j < arr.length ; j++){
              p2 = arr[j];
              if((p1 + p2) == target) {
                  System.out.println("The two indexes are " + k + " and " + j);
                  System.exit(0);
              } 
            }
        }
        System.out.println("Not found!!");
}
}
