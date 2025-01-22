/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM1;
import java.util.*;
import java.io.*;

/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        
        String[][] participants_info = new String[4][4];
        try{
            Scanner sc = new Scanner(new FileInputStream("participants.txt"));
            int i = 0;
            while(sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                participants_info[i] = line;
                i++;
            }
            
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        for (int i = 0; i < 4; i++) {
            String name = participants_info[i][0];
            String gender = participants_info[i][1];
            String age = participants_info[i][2];
            String address = participants_info[i][3];
            
            System.out.printf("%-12s%-4s%-4s%s\n", name, gender, age, address);
        }
        
        participants_info = conversion(participants_info);
        
        boolean[] found = {false, false, false, false};
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if(found[i] && found[j]) {
                    continue;
                }

                if(participants_info[i][3].equals(participants_info[j][3])) {
                    found[i] = true;
                    found[j] = true;
                }
            }
        }
        
        boolean inPair = true;
        for (int i = 0; i < 4; i++) {
            if(found[i]){
                continue;
            }
            else{
                inPair = false;
                break;
            }
        }
        
        System.out.println("");
        if(inPair) {
            System.out.println("Participants are in pairs. ");
        }
        else {
            System.out.println("Participants are not in pairs, cannot proceed.");
        }
        
        seatArrange(participants_info);
    }
    
    public static String[][] conversion(String[][] info) {
        for (int i = 0; i < 4; i++) {
            info[i][3] = info[i][3].replaceAll(" ", "").toUpperCase();
        }
        return info;
    }
    
    public static void seatArrange(String[][] info) {
        try {
            PrintWriter pw = new PrintWriter("grouping.txt");
            String index = "0123";
            String[] seats = {"Seat A", "Seat B", "Seat C", "Seat D"};
            int i = 0;
            int prev = 0;
            pw.write(seats[i] + " : " + info[0][0] + ", " + info[0][2] + "years old\n");
            index = index.replaceFirst("0", "");
            i++;
            while(index.length() != 0) {
                for (int j = 1; j < index.length() + 1; j++) {
                    if(index.length() == 1) {
                        pw.write(seats[i] + " : " + info[Character.getNumericValue(index.charAt(0))][0] + ", " + info[Character.getNumericValue(index.charAt(0))][2] + "years old");
                        index = index.replaceFirst(index, "");
                    }
                    if(info[j][3].equals(info[prev][3])) {
                        continue;
                    }
                    else {
                        pw.write(seats[i] + " : " + info[j][0] + ", " + info[j][2] + "years old\n");
                        i++;
                        prev = j;
                        index = index.replaceFirst(Integer.toString(j), "");
                        break;
                    }
                }
            }
            pw.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
