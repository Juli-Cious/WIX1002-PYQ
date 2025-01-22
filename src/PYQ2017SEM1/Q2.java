/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017SEM1;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the initial tuition fee (ie year 1): ");
        double ini_fee = sc.nextDouble();
        System.out.print("Enter the yearly rate of increment (e.g enter 5.2 for 5.2%) ");
        double increment = sc.nextDouble() / 100;
        System.out.print("Enter the year for which you wish to compute the tuition fee for: ");
        int year = sc.nextInt();
        
        double computed_fee = computeFee(ini_fee, increment, year);
        System.out.println("Computed fee for year " + year + " is: " + computed_fee);
    
    }
    
    public static double computeFee(double ini_fee, double increment, int year) {
        double tuition_fee;
        int count = 1;
        tuition_fee = ini_fee;
        while(count < year) {
            tuition_fee *= (1 + increment);
            count++;
        }
        return tuition_fee;
    }
}
