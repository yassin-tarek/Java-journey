/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.methods;

/**
 *
 * @author yassi
 */
public class Methods {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        mymethod(); // calling my new method
        welcome();
        printName("yassin", "tarek");
        printNameAge("Yassin", "Tarek", 20);
        checkAge(17);
        checkAge(19);
        int x = 5 , y = 6;
        System.out.println("the sum of x and y is "+ sumTwoInt(x, y));
        System.out.println(powerOfNum(2 , -2));
        System.out.println("sum of 1 and 2 is " + sum(1 , 2));
        System.out.println("sum of 1.2 and 2.5 is " + sum(1.2 , 2.5));
    }
    
    // creating new method 
    static void mymethod(){
        System.out.println("I just got executed");
    }
    
    // welcome message
    static void welcome(){
        System.out.println("welcome to my methods program");
    }
    
    // now the parameters 
    static void printName(String fname , String sname){
        System.out.println(fname + " " + sname);
    }
    
    // print name and age
    static void printNameAge(String fname , String lname , int age){
        System.out.println("Hello my name is " + fname +" " + lname +"and my age is " + age);
    }
    
    // check age
    static void checkAge(int age){
        if (age < 18){
            System.out.println("Access denied - You are not old enough!");
        }else{
            System.out.println("Access granted - You are old enough!");
        }
    }
    
    // get sum of two int
    static int sumTwoInt(int x , int y){
        return x + y;
    }
    
    // power calculation
    static float powerOfNum(float base , int exponent){
        if(exponent == 0)
            return 1;
        
        if(base == 0)
            return 0;
        
        else if(exponent < 0){
            return powerOfNum(1/base, Math.abs(exponent));
        }
        
        else{
            return powerOfNum(base , exponent-1)*base;
        }
    }
    
    // now talk about method overloading
    static int sum(int x , int y){
     return x + y;   
    }
    
    static float sum(float x , float y){
     return x + y;
    }
    
    static double sum(double x , double y){
     return x + y;
    }    
}
