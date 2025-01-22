/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017SEM2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Enter the number of random integer: ");
        int num = sc.nextInt();
    
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = rand.nextInt(10001);
        }
        
        System.out.print("The random integer : ");
        displayInt(arr);
        System.out.println("");
        
        System.out.print("Minimum number: ");
        System.out.println(getMin(arr));
        
        System.out.print("The approximation of the integer to the nearest hundred : ");
        displayApprox(arr);
        System.out.println("");
        
        System.out.print("The random integer in reverse order: ");
        reversed(arr);
    }
    
    public static void displayInt(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if(i < min) {
                min = i;
            }
        }
        return min;
    }
    
    public static void displayApprox(int[] arr) {
        for (int i : arr) {
            if(i % 100 >= 50) {
                i = i + (100 - i % 100);
            }
            else if(i % 100 < 50) {
                i = i - i % 100;
            }
            System.out.print(i + " ");
        }
    }
    
    public static void reversed(int[] arr) {
        for (int i : arr) {
            int reversed = 0;
            while(i > 0) {
                reversed = reversed * 10;
                reversed = reversed + i % 10;
                i = i / 10;
            }
            System.out.print(reversed + " ");
        }
    }
}
