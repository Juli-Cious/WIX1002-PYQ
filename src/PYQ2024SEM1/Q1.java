/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM1;

import java.util.Scanner;

/**
 *
 * @author justb
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        
        System.out.println("Enter a number, enter 'X' to quit.");
        String num = sc.next();
        while(!num.equalsIgnoreCase("X")){
            int number;
            try {
                number = Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                num = sc.next();
                continue;
            }
            
            if(number > 0) {
                positive++;
            }
            else if(number < 0) {
                negative++;
            }
            else {
                zeros++;
            }
            num = sc.next();
        }
        
        System.out.println("Positive number: " + positive);
        System.out.println("Negative number: " + negative);
        System.out.println("Zero: " + zeros);
        
        
    }
}
