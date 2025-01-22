/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PYQ2017SEM1;
import java.util.*;
import java.io.*;
/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String args[]) {
        String letters = "";
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int temp;
            do {
                temp = rand.nextInt(65 , 123);
            } while(temp > 90 && temp < 97);
            
            int letter = temp;
            
            letters += (char) letter;
        }
        
        System.out.println("The string generated is: " + letters);
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("data.txt"));
            pw.write(letters);
            pw.close(); //Dont forget to close
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        char[] ascend = sort(letters.toCharArray(), '>');
        char[] descend = sort(letters.toCharArray(), '<');
        
        String ascending = "", descending = "";
        for (int i = 0; i < ascend.length; i++) {
            ascending += ascend[i];
            descending += descend[i];
        }
        
        System.out.println("String sorted in ascending order: " + ascending);
        System.out.println("String sorted in descending order: " + descending);
        
        try {
            Scanner sc = new Scanner(new FileInputStream("data.txt"));
            String line = sc.nextLine();
            System.out.println("Original string from file: " + line);
          
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static char[] sort(char[] letter, char mode) {
        
        //descending < , ascending >
        switch(mode) {
            case '<': 
                for (int i = 0; i < letter.length; i++) {
                    for (int j = 0; j < letter.length - 1; j++) {
                        if(letter[j] < letter[j + 1]) {
                            char temp = letter[j];
                            letter[j] = letter[j + 1];
                            letter[j + 1] = temp;
                        }
                    }
                }
                break;
            case '>':
                for (int i = 0; i < letter.length; i++) {
                    for (int j = 0; j < letter.length - 1; j++) {
                        if(letter[j] > letter[j + 1]) {
                            char temp = letter[j];
                            letter[j] = letter[j + 1];
                            letter[j + 1] = temp;
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid mode.");
                break;
        }
        
        return letter;
    }
}
