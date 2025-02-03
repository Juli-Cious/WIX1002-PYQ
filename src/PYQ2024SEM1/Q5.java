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
        File participantstxt = new File("participants.txt");
        String[][] vals = readParticipants(participantstxt);
        
        for (String[] val : vals) {
            for (String string : val) {
                System.out.print(string + " ");
            }
            System.out.println("");
        }
        
        for (String[] val : vals) {
            val[3] = normalizeAddress(val[3]);
        }
        
        for (String[] val : vals) {
            for (String string : val) {
                System.out.print(string + " ");
            }
            System.out.println("");
        }
        
        boolean inPairs = checkPair(vals);
        if(inPairs) {
            assignSeats(vals);
        }
    }
    
    public static String[][] readParticipants(File file) {
        String[][] values = new String[4][4];
        
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            
            for (int i = 0; i < values.length; i++) {
                String line = sc.nextLine();
                String[] line_split = line.split(",");
                values[i][0] = line_split[0];
                values[i][1] = line_split[1];
                values[i][2] = line_split[2];
                values[i][3] = line_split[3];
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return values;
    }
    
    public static String normalizeAddress(String s) {
        
//        s.toUpperCase(); //change all to uppercase
//        s.replaceAll(" ", ""); //remove all white spaces
        return s.toUpperCase().replaceAll(" ", "");
    }
    
    public static boolean checkPair(String[][] values) {
        boolean[] paired = {false, false, false, false};
        
        for (int i = 0; i < 4; i++) {
            if(paired[i]) continue;
            for (int j = i + 1; j < 4; j++) {
                if(paired[i]) continue;
                if(values[i][3].equals(values[j][3])) {
                    if(!values[i][1].equals(values[j][1])) {
                        paired[i] = true;
                        paired[j] = true;
                        break;
                    }
                }
            }
        }
        
        for (boolean b : paired) {
            if(b == false) {
                System.out.println("Participants are not in pairs, cannot proceed.");
                return false;
            }
        }
        System.out.println("Participants are in pairs. ");
        return true;
    }
    
    public static void assignSeats(String[][] values) {
        String[] pairs = new String[4];
        
        pairs[0] = values[0][0] +", " + values[0][2] + " years old";
        String last_address = values[0][3];
        
        int i = 1;
        int index = 1;
        boolean[] foundSeat = {true, false, false, false};
        while(true) {
            if(i == 4) {
                i = 0;
            }
            if(index == 4) {
                break;
            }
            if(!last_address.equals(values[i][3]) && !foundSeat[i]) {
                pairs[index] = values[i][0] +", " + values[i][2] + " years old";
                index++;
                last_address = values[i][3];
                foundSeat[i] = true;
            }
            i++;
        }
        
        System.out.println("Seat A: " + pairs[0]);
        System.out.println("Seat B: " + pairs[1]);
        System.out.println("Seat C: " + pairs[2]);
        System.out.println("Seat D: " + pairs[3]);
    }
}
