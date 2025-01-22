/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM1;
import java.util.*;
/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        int[][] seating_plan = initializeSeatingPlan();
        
        for(int[] seats: seating_plan) {
            for(int desk: seats) {
                System.out.print(desk + " ");
            }
            System.out.println("");
        }
        
        analyzeSeating(seating_plan);
    }
    
    static int[][] initializeSeatingPlan() {
        int[][] seats = new int[5][5];
        Random rand = new Random();
        
        for(int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = rand.nextInt(0, 2);
            }
        }
        
        return seats;
    }
    
    static void analyzeSeating(int[][] seatingPlan) {
        int max = 0;
        int row_max = 0;
        int row = 1;
        int total = 0;
        for(int[] rows : seatingPlan) {
            int count = 0;
            for(int desk : rows) {
                if(desk == 1) {
                    count++;
                    total++;
                }
            }
            if(count > max) {
                max = count;
                row_max = row;
            }
            row++;
        }
        
        System.out.println("Total occupied: " + total);
        System.out.println("Max: " + max);
        System.out.println("Max row: " + row_max + ", index: " + (row_max - 1));
    }
}
