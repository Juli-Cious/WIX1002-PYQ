/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016SEM2;

import java.util.Scanner;

/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        int number = sc.nextInt();
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        System.out.println("The sum of the digits is " + sum);
    }
}
