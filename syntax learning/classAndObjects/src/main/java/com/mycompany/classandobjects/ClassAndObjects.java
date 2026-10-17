package com.mycompany.classandobjects;

// class name should starts with capital litters and matches file's name

public class ClassAndObjects {
    int x = 13;
    public static void main(String[] args) {
    // create an object
    // ClassAndObjects(); is the constructor that creates the object 
    // myObj is a variable that will points to the object that has been created
    // in java objects are created in heap will variables in stack
     ClassAndObjects myObj1 = new ClassAndObjects();
        System.out.println(myObj1.x);
    // the second object
     ClassAndObjects myObj2 = new ClassAndObjects();
        System.out.println(myObj2.x);
    }
}
