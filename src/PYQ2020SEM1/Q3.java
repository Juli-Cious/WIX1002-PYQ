/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2020SEM1;
import java.util.*;
import java.io.*;
/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String[] args) {
        int[] num = new int[9];
        try {    
            Scanner sc = new Scanner(new FileInputStream("raw.txt"));
            while(sc.hasNextLine()) {
                int value = Integer.parseInt(sc.nextLine());
                value = value - 2; //from 2 -> 0 (to match array index)
                num[value]++;
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        System.out.println("Frequency Distribution Table");
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0) {
                System.out.print((i + 2) + " : " + num[i]);
                System.out.println("");
            }
            if(num[i] > max) {
                max = num[i];
                max_index = i + 2;
            }
        }
        
        System.out.println("The mode of this dataset is : " + (max_index));
    }
}
