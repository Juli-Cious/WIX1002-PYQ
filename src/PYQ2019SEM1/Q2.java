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
        printMatrix(addMatrix(matrix_a.clone(), matrix_b.clone()));
        
        
        System.out.println("Matrix A x B: ");
        printMatrix(multMatrix(matrix_a.clone(), matrix_b.clone()));
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
        int[][] ans = new int[A.length][B.length];
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                ans[i][j] = A[i][j] + B[i][j];
            }
        }
        
        return ans;
    }
    
    public static int[][] multMatrix(int[][] A, int[][] B) {
        int[][] ans = new int[A.length][B.length];
        
        int row = 0;
        int column = 0;
        
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                for (int k = 0; k < A.length; k++) { //multiply two array elements
                    ans[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return ans;
    }
}
