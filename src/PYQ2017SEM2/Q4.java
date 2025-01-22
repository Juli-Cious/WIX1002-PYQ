/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017SEM2;
import java.util.*;
import java.io.*;

/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("Q4.dat"));
            int[] days = {25, 29, 19, 31, 31, 29};
            int[] month = {3, 2, 1, 9, 5, 2};
            int[] year = {2017, 2100, 2017, 2015, 2017, 2016};
            for (int i = 0; i < days.length; i++) {
                obj.writeInt(days[i]);
                obj.writeInt(month[i]);
                obj.writeInt(year[i]);
            }
            obj.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Q4.dat"));
            while(true) {
                int q = obj.readInt();
                int m = obj.readInt();
                int y = obj.readInt();
                DayOfTheWeek day = new DayOfTheWeek(q, m, y);
                
                day.displayDayOfWeek();
            }
        } catch (EOFException e) {
            System.out.println("End of file reached. ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
        
    }
}

class DayOfTheWeek {
    private int h, q, m, y, J, K;

    public DayOfTheWeek(int q, int m, int y) {
        this.q = q;
        this.m = m;
        this.y = y;
    }
    
    public boolean checkInputs() {
        int[] days_of_month = {31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31, 28}; //March, April ...... Janary, February
        
        int m = this.m;
        int y = this.y;
        
        if(m == 1) {
            m = 13;
            y--;
        }
        else if(m == 2) {
            m = 14;
            y--;
        }
        
        if(isLeapYear(this.y)) { //if leap year, february has 29 days.
            days_of_month[11] = 29;
        }
        
        
        if(days_of_month[m - 3] >= this.q) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        else if (year % 400 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void displayDayOfWeek() { 
        if(checkInputs()) {
            int q = this.q;
            int m = this.m;
            int y = this.y;
            int J = this.J;
            int K = this.K;
            
            if(m == 1) {
                m = 13;
                y--;
            }
            else if(m == 2) {
                m = 14;
                y--;
            }

            this.K = y % 100;
            this.J = y / 100;
            this.h = (this.q + Math.floorDiv(13 * (m + 1), 5) + this.K + Math.floorDiv(this.K , 4) + Math.floorDiv(this.J , 4) + 5 * this.J) % 7;
            String day = "";
            switch(this.h) {
                case 0:
                    day = "Saturday";
                    break;
                case 1:
                    day = "Sunday";
                    break;
                case 2:
                    day = "Monday";
                    break;
                case 3:
                    day = "Tuesday";
                    break;
                case 4:
                    day = "Wednesday";
                    break;
                case 5:
                    day = "Thursday";
                    break;
                case 6:
                    day = "Friday";
                    break;
                default:
                    System.out.println("Invalid day.");
             }
             System.out.printf("%d/%d/%d is %s\n", this.q, this.m, this.y, day);
        }
        else {
            System.out.printf("%d/%d/%d is invalid input.\n", this.q, this.m, this.y);
        }
    }
    
}