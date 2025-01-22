/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2019SEM2;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        char choice;
        do{
            System.out.print("What is ");
            int a = rand.nextInt(0, 10);
            int b = rand.nextInt(0, 10);
            
            System.out.print(a + " + " + b + " ? ");
            int answer = sc.nextInt();
            
            System.out.print(a + " + " + b + " = " + answer);
            if((a + b) == answer) {
                System.out.println(" is true");
            } else {
                System.out.println(" is false");
            }
            
            System.out.print("Do you want to try another question (y/n) ? : ");
            choice = sc.next().charAt(0);
            while(choice != 'y' && choice != 'n') {
                System.out.print("Please enter a valid option. : ");
                choice = sc.next().charAt(0);
            }
        } while(choice == 'y');
        System.out.println("Program ends....");
    }
}
