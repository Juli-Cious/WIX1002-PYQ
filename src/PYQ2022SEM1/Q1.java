/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PYQ2022SEM1;
import java.util.Random;
/**
 *
 * @author justb
 */
public class Q1 {

    public static void main(String args[]) {
        Random rand = new Random();
        char c = 'Z';
        char[] car_plate = new char[7];
        
        int length_of_word = rand.nextInt(9);
        char[] word = new char[length_of_word];
        
//        ▪ Generate 3 random price values (100.00-300.00) and display the price values in two decimal places.
//        ▪ Generate 5 random even-numbered years (1990-2030) and display the years.
//        ▪ Generate 1 random car plate number and display the car plate number. The car plate number begin with 5 digits and end with two uppercase letters.
//        ▪ Generate 1 random word and display the word. The word consists of maximum 8 characters and each character must be from a-z or A-Z.
        
        // The questions says "You must use the Random class nextInt(int bound), 
        // nextDouble() methods and char c = 'Z'; to solve the above problems."
        // But the question never says you must ONLY use these methods and char c = 'Z', 
        // So I took some liberties :p
        
        System.out.print("3 Random price values: ");
        for (int i = 0; i < 3; i++) {
            double x = rand.nextDouble();
            int y = rand.nextInt(100, 301);
            while(x + y < 100 || x + y > 300) {
                x = rand.nextDouble();
                y = rand.nextInt(100, 301);
            }
            double z = x + y;
            System.out.printf("%.2f ", z);
        }
        System.out.println("");
        
        System.out.print("5 Random even-numbered years: ");
        for (int i = 0; i < 5; i++) {
            int year;
            do {
                year = rand.nextInt(1990, 2031);
            } while(year % 2 != 0);
            System.out.printf("%d ", year);
        }
        
        System.out.println("");
        System.out.print("Car plate number: ");
        for (int i = 0; i < 7; i++) {
            car_plate[i] = (char) rand.nextInt('0','9');
            if(i > 4) {
                do {
                    car_plate[i] = (char) rand.nextInt(c);
                } while(!(car_plate[i] > 'A' && car_plate[i] < 'Z'));
            }
        }
        for (char a : car_plate) {
            System.out.print(a);
        }
        System.out.println("");
        
        System.out.print("Random word: ");
        for (int i = 0; i < length_of_word; i++) {
            do {
                word[i] = (char)rand.nextInt(Character.MAX_VALUE);
            } while(!(word[i] > 'A' && word[i] < 'Z' || word[i] > 'a' && word[i] < 'z'));
        }
        for (char a : word) {
            System.out.print(a);
        }
        System.out.println("");
    }
}
