/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM2;
import java.util.*;
import java.io.*;

/**
 *
 * @author justb
 */
public class Q1 {
    public static void main(String[] args) {
        File in = new File("tictactoe.txt");

        try {
            Scanner sc = new Scanner(new FileInputStream(in));
            int i = 0;
            char[][] board = new char[3][3];
            int row = 0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(!line.equals("#")) {
                    board[row] = line.toCharArray();
                    row++;
                }
                else {
                    int empty = 0;
                    System.out.println("Game " + (i + 1) + ":");
                    System.out.println("Tic-Tac-Toe Board: ");
                    for(char[] a : board) {
                        for(char move : a) {
                            if(move == '.') {
                                System.out.print("  ");
                                empty++;
                            } else {
                                System.out.print(move + " ");
                            }
                        }
                        System.out.println("");
                    }
                    char winner = checkWinner(board);

                    switch(winner) {
                        case 'D':
                            if(empty > 0) {
                                System.out.println("Winner: None(on going)");
                            }
                            else {
                                System.out.println("Winner: Draw");
                            }
                            break;
                        case 'O':
                            System.out.println("Winner: O");
                            break;
                        case 'X':
                            System.out.println("Winner: X");
                            break;
                    }
                    System.out.println("");
                    i++;
                    row = 0;
                }
            }
        
        
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //
    public static char checkWinner(char[][] board) {
        char win = 'D';
        if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != '.') {
            win = board[0][0];
        }
        else if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != '.') {
            win = board[1][0];
        }
        else if(board[2][0] == board[0][1] && board[2][0] == board[0][2] && board[2][0] != '.') {
            win = board[2][0];
        }
        else if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != '.') {
            win = board[0][0];
        }
        else if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != '.') {
            win = board[0][1];
        }
        else if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != '.') {
            win = board[0][2];
        }
        else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '.') {
            win = board[0][0];
        }
        else if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '.') {
            win = board[0][2];
        }
        
        return win;
    }
}
