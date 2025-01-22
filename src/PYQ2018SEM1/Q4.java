/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2018SEM1;
import java.util.*;
import java.io.*;

/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        File datafile = new File("Q4.txt");
        String[] name;
        double[] final_scores;
        int lines_count = 0;
        
        try { //get size of txt file
            Scanner sc = new Scanner(new FileInputStream(datafile));
            while(sc.hasNextLine()) {
                sc.nextLine();
                lines_count++;
            }
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        name = new String[lines_count];
        final_scores = new double[lines_count];
        
        try {
            Scanner sc = new Scanner(new FileInputStream(datafile));
            int i = 0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(" ");
                name[i] = data[0];
                double max = Double.MIN_VALUE;
                double min = Double.MAX_VALUE;
                int max_index = 0;
                int min_index = 0;
                double total = 0;
                
                double[] scores = { Double.parseDouble(data[1]), 
                                    Double.parseDouble(data[2]), 
                                    Double.parseDouble(data[3]), 
                                    Double.parseDouble(data[4]), 
                                    Double.parseDouble(data[5]) };
                
                for (int j = 0; j < scores.length; j++) {
                    if(scores[j] > max){
                        max = scores[j];
                        max_index = j;
                    }
                    if(scores[j] < min) {
                        min = scores[j];    
                        min_index = j;
                    }
                }
                
                scores[max_index] = 0;
                scores[min_index] = 0;
                
                for (int j = 0; j < scores.length; j++) {
                    total += scores[j];
                }
                
                final_scores[i] = total * Double.parseDouble(data[6]);
                i++;
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        double winner = Double.MIN_VALUE;
        int winner_index = 0;
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i] + " scores " + final_scores[i]);
            if(final_scores[i] > winner) {
                winner = final_scores[i];
                winner_index = i;
            }
        }
        
        System.out.println(name[winner_index] + " is the winner. ");
    }
}
