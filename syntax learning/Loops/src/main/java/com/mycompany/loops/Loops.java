package com.mycompany.loops;


public class Loops {

    public static void main(String[] args) {
        // while loop
        int i = 0;
        while(i < 5){
            System.out.println("i = " + i);
            i++;
        }
        // now do while
        System.out.println("------------------------------------------");
        int k = 0;
        do{
            System.out.println("k = " + k++);
        }while(k < 5);
        // for loop
        System.out.println("------------------------------------------");
        for(int n = 0 ; n < 5 ; n++){
            System.out.println("n = " + n);
        }
        //sum of numbers
        int sum = 0;
        for(int n = 0 ; n < 5 ; n++){
        sum += n;
        }
        System.out.println("the sum = " + sum);
        // nested loops
        for (int r = 1; r <= 3; r++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(r * j + " ");
                        }
                  System.out.println();
                }
        // for each loop ecery element in array
        // for (type variable name : array name)
        String[] cars = {"Volvo","bmw","ford","mazda"}; 
        for (String car : cars){        // it is like for each car in cars
            System.out.println(car);
        }
    }
}
