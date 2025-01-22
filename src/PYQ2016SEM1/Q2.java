/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016SEM1;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String[] args) {
        int computer_win = 0;
        int user_win = 0;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int choice;
        while(computer_win < 3 && user_win < 3) {
            System.out.print("Enter 1.Paper 2.Scissor 3.Rock: ");
            choice = sc.nextInt();
            
            System.out.print("Player: ");
            switch(choice) {
                case 1:
                    System.out.print("Paper ---- ");
                    break;
                case 2:
                    System.out.print("Scissor ---- ");
                    break;
                case 3:
                    System.out.print("Rock ---- ");
                    break;
            }
            
            int computer_choice = rand.nextInt(1,4);
            
            System.out.print("Computer: ");
            switch(computer_choice) {
                case 1:
                    System.out.println("Paper ");
                    break;
                case 2:
                    System.out.println("Scissor ");
                    break;
                case 3:
                    System.out.println("Rock ");
                    break;
            }
            
            if(choice == computer_choice) {
                System.out.println("Draw. ");
            }
            else if(choice == 1 && computer_choice == 3) {
                user_win++;
                System.out.println("Player win " + user_win + " time(s).");
            }
            else if(choice == 2 && computer_choice == 1) {
                user_win++;
                System.out.println("Player win " + user_win + " time(s).");
            }
            else if(choice == 3 && computer_choice == 2) {
                user_win++;
                System.out.println("Player win " + user_win + " time(s).");
            }
            else {
                computer_win++;
                System.out.println("Computer win " + computer_win + " time(s).");
            }
        }
        
        if(computer_win == 3) {
            System.out.println("Computer wins the game.");
        }
        else {
            System.out.println("Player wins the game.");
        }
    }
}
