package com.mycompany.math_methods;
public class Math_methods {

    public static void main(String[] args) {
        // Math is a static class that contains methods you can use
        // to get max
        System.out.println(Math.max(3, 4));
        // to get min
        System.out.println(Math.min(3, 4));
        // to get sqrt
        System.out.println(Math.sqrt(64));
        // to get abs
        System.out.println(Math.abs(-2524.4));
        // to get power
        System.out.println(Math.pow(2, 8));
        // Math.round(x) - rounds to the nearest integer
        System.out.println(Math.round(5.6));
        // Math.ceil(x) - rounds up (returns the smallest integer greater than or equal to x)
        System.out.println(Math.ceil(3.1));
        // Math.floor(x) - rounds down (returns the largest integer less than or equal to x)
        System.out.println(Math.floor(3.9));
        // generate random number
        System.out.println((int) (Math.random()*100));
        
    }
}
