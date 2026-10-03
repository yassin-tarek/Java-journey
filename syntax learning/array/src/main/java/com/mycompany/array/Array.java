package com.mycompany.array;

public class Array {

    public static void main(String[] args) {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        System.out.println(cars[1]);
        cars[1] = "mercedes benz";
        System.out.println(cars[1]);
        int[] myNum = {10, 20, 30, 40};
        System.out.println("the length of the array " + myNum.length);
        String[]  animals = new String[] {"elephant" , "lion" , "giraffe"};
        // the same and shorter way to write it String[]  animals = {"elephant" , "lion" , "giraffe"};
        // to define an array with specific size
        String[] courses = new String[6];
        courses[0] = "Data structure";
        // to loop an array
        for(int i = 0 ; i < cars.length ; i++){
            System.out.println(cars[i]);
        }
        // also we can use for each
        for(String car : cars){
            System.out.println(car);
        }
        // multidimensional array
        int[][] matrice = {{1 , 2 , 3 } , {4 , 5 , 6} };    // 1    2   3
        System.out.println(matrice[0][2]); // 3                4    5   6
        
    }
}
