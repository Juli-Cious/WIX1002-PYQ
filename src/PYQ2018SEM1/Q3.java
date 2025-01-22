/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2018SEM1;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String[] args) {
        int size, format;
        char type;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter font size: ");
        size = sc.nextInt();
        System.out.print("Enter font type: ");
        type = sc.next().charAt(0);
        System.out.print("Enter format [1 - Vertical, 2 - Horizontal]: ");
        format = sc.nextInt();
        
        printEight(size, type, format);
    }
    
    public static void printEight(int size, char type, int format) {
        
        
        switch(format) {
            case 1: //Vertical
                int line_v = 3 + (size - 1);
                int height_v = 3 + (size * 2);
                
                for (int i = 0; i < height_v; i++) {
                    for (int j = 0; j < line_v; j++) {
                        if(i == 0 || i == height_v - 1 || i == Math.ceil(height_v / 2)) {
                            System.out.print(type);
                        }
                        else {
                            if(j == 0 || j == line_v - 1) {
                                System.out.print(type);
                            }
                            else{
                                System.out.print(" ");
                            }
                        }
                    }
                    System.out.println("");
                }
                break;
            case 2: //Horizontal
                int line_h = 3 + (size * 2);
                int height_h = 3 + (size - 1);
                for (int i = 0; i < height_h; i++) {
                    for (int j = 0; j < line_h; j++) {
                        if(i == 0 || i == height_h - 1) {
                            System.out.print(type);
                        }
                        else {
                            if(j == 0 || j == line_h - 1 || j == Math.ceil(line_h / 2)) {
                                System.out.print(type);
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                    }
                    System.out.println("");
                }
                break;
        }
    }
}
