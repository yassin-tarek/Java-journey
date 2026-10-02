package com.mycompany.operators;

public class Operators {

    public static void main(String[] args) {
        int x = 100 + 50;
        System.out.println("The value of x is " + x);
        int y = 600 - 250 ;
        System.out.println("The value of y is "+ y);
        System.out.println("The sum of x and y is "+ (x + y));
        System.out.println("The subtract of x and y is "+ (x - y));
        System.out.println("The multiplication of x and y is "+ (x * y));
        System.out.println("The division of x and y is "+ (x / y));
        System.out.println("The modulus of x and y is "+ (x % y));
        x += 10;
        System.out.println("The value of x is " + x);
        // comparison operators 
        System.out.println(x > y); //false
        System.out.println(x < y); //true
        int age = 17;
        System.out.println(age > 18); // false
        // logical operators 
        boolean isLoggedIn = true;
        boolean isAdmin = false;
        System.out.println("Regular user: " + (isLoggedIn && !isAdmin));
        System.out.println("Has access: " + (isLoggedIn || isAdmin));
        System.out.println("Not logged in: " + (!isLoggedIn));
        // precedence
        int a = 10 , b = 3 , c = 2;
        System.out.println(a + b * c);
        System.out.println((a + b) * c);
        
    }
}
