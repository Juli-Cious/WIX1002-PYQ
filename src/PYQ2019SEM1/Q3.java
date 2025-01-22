/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2019SEM1;

import java.util.Scanner;

/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter genome String [quit to stop] : ");
        String genome = sc.next();
        
        while(!genome.equalsIgnoreCase("quit")) {
            boolean found = false;
            String[] temp = genome.split("ATG");
            String[] genes;
            for (int i = 0; i < temp.length; i++) {
                if(temp[i].contains("TAG")) {
                    genes = temp[i].split("TAG");
                    for (int j = 0; j < genes.length; j++) {
                        if(genes[j].length() % 3 == 0) {
                            int a = 0;
                            int b = 3;
                            for (int k = 0; k < genes[j].length() / 3; k++) {
                                System.out.println(genes[j].substring(a, b));
                                a += 3;
                                b += 3;
                                found = true;
                            }
                        }
                    }
                }
                else if (temp[i].contains("TAA")) {
                    genes = temp[i].split("TAA");
                    for (int j = 0; j < genes.length; j++) {
                        if(genes[j].length() % 3 == 0) {
                            int a = 0;
                            int b = 3;
                            for (int k = 0; k < genes[j].length() / 3; k++) {
                                System.out.println(genes[j].substring(a, b));
                                a += 3;
                                b += 3;
                                found = true;
                            }
                        }
                    }
                }
                else if (temp[i].contains("TGA")) {
                    genes = temp[i].split("TGA");
                    for (int j = 0; j < genes.length; j++) {
                        if(genes[j].length() % 3 == 0) {
                            int a = 0;
                            int b = 3;
                            for (int k = 0; k < genes[j].length() / 3; k++) {
                                System.out.println(genes[j].substring(a, b));
                                a += 3;
                                b += 3;
                                found = true;
                            }
                        }
                    }
                }
            }

            if(!found) {
                System.out.println("No gene is found. ");
            }
            System.out.print("Enter genome String [quit to stop] : ");
            genome = sc.next();
        }
        
    }
}
