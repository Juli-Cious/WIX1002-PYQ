/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016SEM1;
import java.util.*;
/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String[] args) {      
        System.out.print("Enter the number of random integer: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Random rand = new Random();
        int max = Integer.MIN_VALUE;
        
        System.out.print("The random integer : ");
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1001);
            System.out.print(array[i] + " ");
            if(max < array[i]) {
                max = array[i];
            }
        }
        
        System.out.println("\nMaximum number: " + max);
        
        System.out.print("The approximation of the integer to the nearest tenth : ");
        for (int i : array) {
            int first_digit = i % 10;
            if(first_digit <= 4) {
                i -= first_digit;
            }
            else {
                i += (10 - first_digit);
            }
            System.out.print(i + " ");
        }
        
        System.out.print("\nThe random integer in reverse order: ");
        for (int i : array) {
            int reversed = 0;
            while(i > 0) {
                reversed *= 10;
                reversed += i % 10;
                
                i = i / 10;
            }
            System.out.print(reversed + " ");
        }
        System.out.println("");
    }
}
