/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2019SEM1;
import java.util.*;
import java.io.*;
/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        System.out.println("The essay is: ");
        File essay = new File("myAmbition.txt");
        char[] alphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] count = new int[alphabets.length];
        int sentence_count = 0;
        int word_count = 0;
        try {
            Scanner sc = new Scanner(new FileInputStream(essay));
            while(sc.hasNext()) {
                String word = sc.next();
                System.out.print(word + " ");
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < alphabets.length; j++) {
                        //check if == 'a' or == 'A' , ignore case!
                        if(word.charAt(i) == alphabets[j] || word.charAt(i) == Character.toLowerCase(alphabets[j])) {
                            count[j]++;
                            break;
                        }
                        else if(word.charAt(i) == '.') {
                            sentence_count++;
                            break;
                        }
                    }
                }
                word_count++;
            }
            
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("");
        System.out.println("Number of sentences : " + sentence_count);
        System.out.println("Number of words : " + word_count);
        
        for (int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i] + " : " + count[i] + " ");
            if(i % 5 == 0 && i != 0) {
                System.out.println("");
            }
        }
    }
}
