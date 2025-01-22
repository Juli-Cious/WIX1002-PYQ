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
public class Q2b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        try{
            checkAge(age);
        } catch(InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void checkAge(int age) throws InvalidAgeException{
        if(age < 18) {
            throw new InvalidAgeException("Less than 18.");
        } else {
            System.out.println("Valid age.");
        }
    }
}

class InvalidAgeException extends Exception {
    String message;
    InvalidAgeException(String message) {
        super(message);
    }

}
