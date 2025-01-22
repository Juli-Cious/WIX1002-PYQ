/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2019SEM1;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        int N = sc.nextInt();
        
        int[][] matrix_a = generateMatrix(N);
        System.out.println("Matrix A: ");
        printMatrix(matrix_a);
        
        int[][] matrix_b = generateMatrix(N);
        System.out.println("Matrix B: ");
        printMatrix(matrix_b);
        
        System.out.println("Matrix A + B: ");
        printMatrix(addMatrix(matrix_a, matrix_b));
        
        System.out.println("Matrix A x B: ");
        printMatrix(multMatrix(matrix_a, matrix_b));
    }
    
    public static int[][] generateMatrix(int N) {
        int[][] matrix = new int[N][N];
        Random rand = new Random();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static int[][] addMatrix(int[][] A, int[][] B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] += B[i][j];
            }
        }
        
        return A;
    }
    
    public static int[][] multMatrix(int[][] A, int[][] B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] *= B[i][j];
            }
        }
        
        return A;
    }
}
