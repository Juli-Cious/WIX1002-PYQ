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
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int lines = sc.nextInt();
        
        int start = 1;
        int spaces = lines - 1;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            
            System.out.print(start);
            int temp = start;

            while(start > 1) {
                start--;
                System.out.print(start);
                if(start == 1) {
                    while(start != temp) {
                        start++;
                        System.out.print(start);
                    }
                    break;
                }
            }
            System.out.println("");
            spaces--;
            start++;
        }
        
    }
}
