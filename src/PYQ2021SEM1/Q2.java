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
    
    public static void findSolution(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        
        char[] operators = {'+', '-', '*', '/'};
        
        boolean found = false;
        for (char operator : operators) {
            
            int result = 0;
            int result_another = 0;
            int result_double_divide = 0;
            String result_string = "";
            String result_another_string = "";
            String result_double_divide_string = "";
            
            switch(operator) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '/':
                    result = x / y;
                    break;
            }
            for (char p : operators) {
                switch(p) {
                    case '+':
                        result = result + z;
                        result_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                        if(operator == '*' || operator == '/') {
                            switch(operator) {
                                case '*':
                                    result_another = x * (y + z);
                                    result_another_string = x + " " + operator + " (" + y + " " + p + " " + z + ") = 18";
                                    break;
                                case '/':
                                    result_another = x / (y + z);
                                    result_another_string = x + " " + operator + " (" + y + " " + p + " " + z + ") = 18";
                                    break;
                            }
                        }
                        break;
                    case '-':
                        result = result - z;
                        result_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                        if(operator == '*' || operator == '/') {
                            switch(operator) {
                                case '*':
                                    result_another = x * (y - z);
                                    result_another_string = x + " " + operator + " (" + y + " " + p + " " + z + ") = 18";
                                    break;
                                case '/':
                                    result_another = x / (y - z);
                                    result_another_string = x + " " + operator + " (" + y + " " + p + " " + z + ") = 18";
                                    break;
                            }
                        }
                        break;
                    case '*':
                        result = result * z;
                        result_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                        if(operator == '+' || operator == '-') {
                            result_string = "(" + x + " " + operator + " " + y + ") " + p + " " + z + " = 18";
                            switch(operator) {
                                case '+':
                                    result_another = x + y * z;
                                    result_another_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                                    break;
                                case '-':
                                    result_another = x - y * z;
                                    result_another_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                                    break;
                            }
                        }
                        break;
                    case '/':
                        result = result / z;
                        result_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                        if(operator == '+' || operator == '-') {
                            result_string = "(" + x + " " + operator + " " + y + ") " + p + " " + z + " = 18";
                            switch(operator) {
                                case '+':
                                    result_another = x + y / z;
                                    result_another_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                                    break;
                                case '-':
                                    result_another = x - y / z;
                                    result_another_string = x + " " + operator + " " + y + " " + p + " " + z + " = 18";
                                    break;
                            }
                        }
                        if(operator == '/') {
                            
                            result_double_divide = (int)(x / (y / (double) z ));
                        }
                        break;
                }

                if(result == 18) {
                    System.out.println(result_string);
                    found = true;
                }
                if(result_another == 18) {
                    System.out.println(result_another_string);
                    found = true;
                }
                if(result_double_divide == 18) {
                    System.out.println(x + " " + operator + " (" + y + " " + p + " " + z + ") = 18");
                    found = true;
                } 
            }
        }
        
        if(!found) {
            System.out.println("No solution found.");
        }
    }
}
