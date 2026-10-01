package com.mycompany.varibales;


public class Varibales {
    // types of variables (string-int-float-char-boolean)
    public static void main(String[] args) {
    String name = "Yassin Tarek";
        System.out.println(name);
        
    int age = 20;
        System.out.println(age);
        age = 21; // assign new value
        System.out.println(age);
    
    final int num = 3; // using final make the variable unchangable read-only also we use it with constants
                        // num = 5; error
    System.out.println(num);
    
    //other variables
    char myletter = 'Y'; // we use single quotation with char while double quotation with stirngs
    boolean check = true;
    //---------------------------------------------------------------------------------------
    //now will learn how to print them
    String firstName = "Yassin";
    String lastName = "Tarek";
    System.out.println(firstName + ' ' + lastName); 
    // there is another way
    String fullName = firstName + ' ' + lastName;
    System.out.println(fullName);
    // the + for strings it concatenate them while in numbers it adds them up
    int a = 1 , b = 2;
    System.out.println(a + b);
    // mixing the numbers with text
    System.out.println("the sum of " + a + " and " + b + " is " +(a+b));
    // the keyword var the compiler indiactes the type of the variable by itself
    var myNum = 5;         // int
    var myDouble = 9.98;   // double
    var myChar = 'D';      // char
    var myBoolean = true;  // boolean
    var myString = "Hello"; // String
    
    }
}
