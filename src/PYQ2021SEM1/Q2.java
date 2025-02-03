/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PYQ2021SEM1;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String args[]) {
        int[] arr = new int[3];
        System.out.print("Enter 3 numbers [1-9] : ");
        
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        
        findSolution(arr);
        
    }
    //two possibilities: (x op y ) op z / x op (y op z)
    public static void findSolution(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        
        
        char[] operators = {'+', '-', '*', '/'};
        for (char op1 : operators) {
            for (char op2 : operators) {
                int result1 = (int) evaluate((evaluate(x, y, op1)), z, op2);
                int result2 = (int) evaluate(x, evaluate(y, z, op2), op1);
                
                if(result1 == 18 && result2 == 18) {
                    System.out.printf("%d %c %d %c %d = 18\n", x, op1, y, op2, z);
                }
                else {
                    if(result1 == 18) {
                        if(op1 == '*' || op1 == '/' && op2 == '-' || op2 == '+') {
                            System.out.printf("%d %c %d %c %d = 18\n", x, op1, y, op2, z);
                        }
                        else {
                            System.out.printf("(%d %c %d) %c %d = 18\n", x, op1, y, op2, z);
                        }
                        
                    }
                    if(result2 == 18) {
                        if(op1 == '+' || op1 == '-' && op2 == '/' || op2 == '*') {
                            System.out.printf("%d %c %d %c %d = 18\n", x, op1, y, op2, z);
                        }
                        else {
                            System.out.printf("%d %c (%d %c %d) = 18\n", x, op1, y, op2, z);
                        }
                    }
                }
            }
        }
    }
    
    public static double evaluate(double a, double b, char op) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return -1;
    }
}
