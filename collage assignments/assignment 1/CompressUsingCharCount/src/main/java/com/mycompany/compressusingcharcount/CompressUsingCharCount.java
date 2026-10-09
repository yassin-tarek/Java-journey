package com.mycompany.compressusingcharcount;
import java.util.Scanner;
public class CompressUsingCharCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = scanner.next();
        String result = "";
        int count = 1;
    for (int i = 0; i < text.length(); i++) {
        while (i + 1 < text.length() &&                 // condtions check by order
               text.charAt(i) == text.charAt(i + 1)) {
            count++;
            i++;
        }
        result += text.charAt(i);
        result += count;
        count = 1;
}
System.out.println(result);
    }
}
