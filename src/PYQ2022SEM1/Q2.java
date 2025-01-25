/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PYQ2022SEM1;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String args[]) {
        File divingtxt = new File("diving.txt");
        int no_of_participants = 0;
        try { //checking the contents
            Scanner sc = new Scanner(new FileInputStream(divingtxt));
            // each participants = 5 lines
            // so number of participants = total lines / 5;
            int count = 0;
            while(sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            
            no_of_participants = count / 5;
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        Diving[] divers = new Diving[no_of_participants];
        try {
            Scanner sc = new Scanner(new FileInputStream(divingtxt));
            
            int count = 0;
            
            do {
                String name = sc.nextLine();
                String country = sc.nextLine();
                double[][] scores = new double[3][7];
                double[] difficulty = new double[3];
                for (int i = 0; i < 3; i++) {
                    String line = sc.nextLine();
                    String[] values = line.split(" ");

                    for (int j = 0; j < 8; j++) {
                        double data = Double.parseDouble(values[j]);
                        if(j == 7) {
                            difficulty[i] = data;
                        }
                        else {
                            scores[i][j] = data;
                        }
                    }
                }
                divers[count] = new Diving(name, country, scores, difficulty);
                count++;
            } while(count < no_of_participants);
            
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        for (int i = 0; i < divers.length; i++) {
            System.out.println(divers[i].toString());
        }
        
        displayWinner(divers);
    }
    
    public static void displayWinner(Diving[] divers) {

        //bubble sort to determine highest scorers
        for (int pass = 1; pass < divers.length; pass++) {
            for (int i = 0; i < divers.length - 1; i++) {
                if(divers[i].finalScore() < divers[i + 1].finalScore()) {
                    Diving temp = divers[i];
                    divers[i] = divers[i + 1];
                    divers[i + 1] = temp;
                }
            }
        }
        
        System.out.println("");
        System.out.println("Gold: " + divers[0].getName() + "(" + divers[0].getCountry() + ")");
        System.out.println("Silver: " + divers[1].getName() + "(" + divers[1].getCountry() + ")");
        System.out.println("Bronze: " + divers[2].getName() + "(" + divers[2].getCountry() + ")");
    }
}

class Diving {
    private String name;
    private String country;
    private double[][] scores = new double[3][7];
    private double[] difficulty = new double[3];

    public Diving(String name, String country, double[][] scores, double[] difficulty) {
        this.name = name;
        this.country = country;
        this.scores = scores;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double finalScore() {
        double grand_total = 0;
        for (int i = 0; i < this.scores.length; i++) {
            double max = 0;
            double max_2nd = 0;
            double min = 100;
            double min_2nd = 100;
            double total = 0;
            
            for (int j = 0; j < this.scores[i].length; j++) {
                double val = this.scores[i][j];
                total += val;
                if(val > max) {
                    max_2nd = max;
                    max = val;
                }
                else if(val < max && val > max_2nd) {
                    max_2nd = val;
                }
                else if(val == max) {
                    max_2nd = max;
                }
                
                if(val < min) {
                    min_2nd = min;
                    min = val;
                }
                else if(val > min && val < min_2nd) {
                    min_2nd = val;
                }
                else if(val == min) {
                    min_2nd = val;
                }
            }
            total -= (max + max_2nd + min + min_2nd);
            grand_total += total * this.difficulty[i];
        }
        return grand_total;
    }
    
    public String toString() {
        return  "Diver : " + this.name + " (" + this.country + ")\n" +
                "Judges Scores : " + this.scores[0][0] + " " + this.scores[0][1] + " " + this.scores[0][2] + " " + this.scores[0][3] + " " + this.scores[0][4] + " " + this.scores[0][5] + " " + this.scores[0][6] + "\n" + 
                "Difficulty Rating : " + this.difficulty[0] + "\n" +
                "Judges Scores : " + this.scores[1][0] + " " + this.scores[1][1] + " " + this.scores[1][2] + " " + this.scores[1][3] + " " + this.scores[1][4] + " " + this.scores[1][5] + " " + this.scores[1][6] + "\n" + 
                "Difficulty Rating : " + this.difficulty[1] + "\n" +
                "Judges Scores : " + this.scores[2][0] + " " + this.scores[2][1] + " " + this.scores[2][2] + " " + this.scores[2][3] + " " + this.scores[2][4] + " " + this.scores[2][5] + " " + this.scores[2][6] + "\n" + 
                "Difficulty Rating : " + this.difficulty[2] + "\n" + 
                "Final Score : " + finalScore(); 
    }
}
