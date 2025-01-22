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
public class Q1b {
    public static void main(String[] args) {
        System.out.print("Input N: ");
        Scanner sc = new Scanner(System.in);
        
        double sum = 0;
        int N = sc.nextInt();
        while(N >= 1) {
            sum += 1.0/N;
            N--;
        }
        
        System.out.println("Sum is: " + sum);
    }
}
