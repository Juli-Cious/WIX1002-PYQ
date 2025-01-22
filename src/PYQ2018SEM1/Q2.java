/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2018SEM1;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("Enter N number: ");
        int N = sc.nextInt();
        int A = 0, AA = 0, AAA= 0;
        
        System.out.print("The random numbers are: ");
        for (int i = 0; i < N; i++) {
            int number = rand.nextInt(50, 151);
            System.out.print(number + " ");
            switch(number % 10) {
                case 0:
                case 1:
                case 2:
                case 3:
                    AAA++;
                    break;
                case 4:
                case 5:
                case 6:
                    AA++;
                    break;
                default:
                    A++;
                    break;
            }
        }
        System.out.println("");
        System.out.println("Group AAA: " + AAA);
        System.out.println("Group AA: " + AA);
        System.out.println("Group A: " + A);
    
    
    }
}
