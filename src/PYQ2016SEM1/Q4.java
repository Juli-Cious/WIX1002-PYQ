/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016SEM1;
import java.util.*;
import java.io.*;
/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        
        try {
            int requirements;
            Scanner sc = new Scanner(new FileInputStream("Password1.txt"));
            boolean strong = true;
            
            
            while(sc.hasNextLine()) {
                requirements = 0;
                String password = sc.nextLine();
                //at least 8 characters
                if (password.length() < 8) {
                    strong = false;
                }
                else {
                    requirements++;
                }
                
                //at least 1 uppercase character
                for (char a : password.toCharArray()) {
                    if(a >= 'A' && a <= 'Z') {
                        requirements++;
                        break;
                    }
                }
                
                for (char a : password.toCharArray()) {
                    if (a >= 'a' && a <= 'z') {
                        requirements++;
                        break;
                    }
                }
                
                for (char a : password.toCharArray()) {
                    if(a >= '0' && a <= '9') {
                        requirements++;
                        break;
                    }
                }
                
                for (char a : password.toCharArray()) {
                    if(!(a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z' || a >= '0' && a <= '9')) {
                        requirements++;
                        break;
                    }
                }
                
                if(requirements == 5) {
                    System.out.println("Strong password.");
                }
                else{
                    System.out.println("Not a strong password.");
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
