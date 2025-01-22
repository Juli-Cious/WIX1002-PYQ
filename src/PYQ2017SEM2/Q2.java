/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017SEM2;

import java.util.Scanner;

/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of teams: ");
        int N = sc.nextInt();
        sc.nextLine(); //consume new line character
        
        String[] teams = new String[N];
        int[] scores = new int[N];
        
        for (int i = 0; i < N; i++) {
            System.out.print("Enter team " + (i + 1) + " name: ");
            String team = sc.nextLine();
            System.out.print("Enter team " + (i + 1) + " score: ");
            int score = sc.nextInt();
            sc.nextLine(); //consume new line character
            
            teams[i] = team;
            scores[i] = score;
        }
        
        //bubble sort
        for (int pass = 0; pass < teams.length + 1; pass++) {
            for (int i = 0; i < teams.length - 1; i++) {
                if(scores[i] < scores[i + 1]) {
                    int temp = scores[i];
                    scores[i] = scores[i + 1];
                    scores[i + 1] = temp;
                    
                    String temp_name = teams[i];
                    teams[i] = teams[i + 1];
                    teams[i + 1] = temp_name;
                }
            }
        }
        
        System.out.println("List of team with the highest team score first. ");
        for (int i = 0; i < teams.length; i++) {
            System.out.print(teams[i] + " (" + scores[i] + ") | ");
        }
    }
}
