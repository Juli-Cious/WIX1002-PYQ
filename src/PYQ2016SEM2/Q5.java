/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016SEM2;

import java.util.Random;

/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        int[][] tictactoe = generateTTT();
        for (int i = 0; i < tictactoe.length; i++) {
            for (int j = 0; j < tictactoe[i].length; j++) {
                System.out.print(tictactoe[i][j]);
            }
            System.out.println("");
        }
        checkRows(tictactoe);
        checkColumns(tictactoe);
    }
    
    public static int[][] generateTTT() {
        int[][] TTTboard = new int[3][3];
        Random rand = new Random();
        for (int i = 0; i < TTTboard.length; i++) {
            for (int j = 0; j < TTTboard[i].length; j++) {
                TTTboard[i][j] = rand.nextInt(2);
            }
        }
        
        return TTTboard;
    }
    
    public static void checkRows(int[][] board) {
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            System.out.println("All " + board[0][0] + " s on row 1. ");
        }
        if(board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            System.out.println("All " + board[1][0] + " s on row 2. ");
        }
        if(board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            System.out.println("All " + board[2][0] + " s on row 3. ");
        }
    }
    
    public static void checkColumns(int[][] board) {
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            System.out.println("All " + board[0][0] + " s on column 1. ");
        }
        if(board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            System.out.println("All " + board[0][1] + " s on column 2. ");
        }
        if(board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            System.out.println("All " + board[0][2] + " s on column 3. ");
        }
    }
}
