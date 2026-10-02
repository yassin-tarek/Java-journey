package com.mycompany.strings;

public class Strings {

    public static void main(String[] args) {
        String name= "Yassin";
        System.out.println("my name is " + name);
        //stings in java is class to know string length we use length() method from the class
        String txt = "abcdefghijklmnopqrstuvwxyz"; 
        System.out.println("the string's length is " + txt.length());
        // there are more methods like toUpperCase() and toLowerCase()
        System.out.println("name to upper: " + name.toUpperCase());
        System.out.println("name to lower: " + name.toLowerCase());
        // to find a character in a string 
        String statment = "my gpa is 3.74";
        System.out.println("the location of gpa starts in index " + statment.indexOf("gpa"));
        // access a character at a specific position in a string
        String greating = "Hello world";
        System.out.println("the charcter at index 7 is " + greating.charAt(7));
        // remove white spaces use trim 
        String whitespaces = "            hello             ";
        System.out.println("removig whitespaces \nbefore: " + whitespaces + "\nafter: " + whitespaces.trim());
        // to use the syntax in another thing use escape charcter \
        System.out.println("my name is \"yassin\"");
        // \n	New Line	
        // \t	Tab	
    }
}
