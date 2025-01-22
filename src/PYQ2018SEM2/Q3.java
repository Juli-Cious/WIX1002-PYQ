/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2018SEM2;
import java.util.*;
import java.io.*;

/**
 *
 * @author justb
 */
public class Q3 {
    public static void main(String[] args) {
        File students = new File("student.txt");
        
        int absent = 0;
        double max = Double.MIN_VALUE;
        int max_index = 0;
        double min = Double.MAX_VALUE;
        int min_index = 0;
        int count = 0;
        String[] names = new String[10];
        double[] marks = new double[10];
        try {
            Scanner sc = new Scanner(new FileInputStream(students));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split(",");
                
                names[count] = values[0];
                marks[count] = Double.parseDouble(values[1]);
                
                if(marks[count] == -1) {
                    absent++;
                    count++;
                    continue;
                }
                if(marks[count] > max) {
                    max = marks[count];
                    max_index = count;
                }
                if(marks[count] < min) {
                    min = marks[count];
                    min_index = count;
                }
                
                count++;
            }
            
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("The student with the highest mark : " + names[max_index] + " " + max);
        System.out.println("The student with the lowest mark  : " + names[min_index] + " " + min);
        System.out.println("The number of students who were absent from the exam: " + absent);
    }
}
