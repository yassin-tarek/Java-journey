package com.mycompany.conditions;

public class Conditions {

    public static void main(String[] args) {
     // the same syntax as C langauge if (condition){operation} 
     boolean isRaining = true ;
     if(isRaining){
         System.out.println("bring the umbrella!");
     }
     // conditions could also be > or < or == amd so on
     int x = 3, y = 4;
     if (x <  y){
         System.out.println("x is less than y");
     // now use if else
     }
     isRaining = false;
     if(isRaining){
         System.out.println("bring the umbrella!");
     }
         else {
         System.out.println("don't bring the umbrella!");
                 }
    // we can right multiple elses
    float gpa = 3.2f;
    if(gpa >= 3.7){
        System.out.println("A");
    }else if(gpa < 3.7 && gpa >= 3.3){
        System.out.println("A-");
    }else if(gpa < 3.3 && gpa >= 3){
        System.out.println("B+");
    }else if(gpa < 3 && gpa >= 2.7){
        System.out.println("B-");
    }else if(gpa < 2.7 && gpa >= 2.3){
        System.out.println("C+");
    }else if(gpa < 2.3 && gpa >= 2){
        System.out.println("C");
    }else if(gpa < 2 && gpa >= 1.7){
        System.out.println("C-");
    }else if(gpa < 1.7 && gpa >= 1.3){
        System.out.println("D+");
    }else if(gpa < 1.3 && gpa >= 1){
        System.out.println("D");
    }else{
        System.out.println("F");}
    // short hand condition
    int time = 18;
    String result = (time < 20) ? "good day" : "good evening";
        System.out.println(result);
    
    // now the switch 
    int day = 4;
    switch(day){
        case 1:
            System.out.println("monday");
            break;
        case 2:
            System.out.println("tuesday");
            break;
        case 3:
            System.out.println("wednesday");
            break;
        case 4:
            System.out.println("thursday");
            break;
        case 5:
            System.out.println("friday");
            break;
        case 6:
            System.out.println("saturday");
            break;
        case 7:
            System.out.println("sunday");
            break;
        default:
            System.out.println("wrong number!!");
    }
    }
    
}