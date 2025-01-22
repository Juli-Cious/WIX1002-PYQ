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
public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = 0, number2 = 0, number3 = 0, number4 = 0, number5 = 0;
        int inputNumber; //number entered by user
        int value = 0;
        int counter = 1;
        
        while(counter <= 5) {
            System.out.println("Enter number: ");
            inputNumber = input.nextInt();
            //define appropriate num if input is between 1-30
            if(inputNumber >= 1 && inputNumber <= 30) {
                switch(counter) {
                    case 1: 
                        number1 = inputNumber;
                        break;
                    case 2:
                        number2 = inputNumber;
                        break;
                    case 3:
                        number3 = inputNumber;
                        break;
                    case 4:
                        number4 = inputNumber;
                        break;
                    case 5:
                        number5 = inputNumber;
                        break;
                }
            counter++;
            }
            else {
                System.out.println("Invalid input\nNumber should be between 1 and 30");
            }
        
        }
        
        for (counter = 1; counter <= 5; counter++) {
            switch(counter) {
                case 1:
                    value = number1;
                    break;
                case 2:
                    value = number2;
                    break;
                case 3:
                    value = number3;
                    break;
                case 4:
                    value = number4;
                    break;
                case 5:
                    value = number5;
                    break;
            }
            for (int j = 0; j < value; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
