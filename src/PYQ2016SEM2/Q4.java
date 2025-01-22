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
public class Q4 {
    public static void main(String[] args) {
        System.out.print("Enter the value of n for a regular polygon, n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print("Enter the length of a particular side of the regular polygon (in meter), s: ");
        double s = sc.nextDouble();
        
        System.out.println("The area is: " + area(n, s) + " squared meters.");
    }
    
    public static double area(int n, double s) {
        double area = (n * s * s)/ (4 * Math.tan((180.0/n) * (Math.PI)/(180))); //must be converted to radians
        return area;
    }
}
