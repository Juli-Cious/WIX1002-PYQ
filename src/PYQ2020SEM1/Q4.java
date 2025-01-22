/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2020SEM1;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        File log = new File("sampleLog.txt");
        
        int no_of_records = 0;
        try {
            Scanner sc = new Scanner(new FileInputStream(log));
            while(sc.hasNextLine()) {
                sc.nextLine();
                no_of_records++;
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Reading from log file....");
        System.out.println("*".repeat(30));
        System.out.println("Records read from log file: \n");
        String[][] records = new String[no_of_records][22];
        try {
            Scanner sc = new Scanner(new FileInputStream(log));
            int count = 0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                records[count] = line.split(" ");
                count++;
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> job_count = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            System.out.println("Record " + (i+1));
            for (int j = 0; j < records[i].length; j++) {
                if(records[i][j].isEmpty()) {
                    break;
                }
                else{
                    System.out.println("\t" + records[i][j]);
                    if(j == 1) {
                        String line = records[i][j];
                        String type = line.split(";")[1];
                        if(type.equalsIgnoreCase("S")) {
                            String username = line.split(";")[3].split("=")[1];
                            if(!name.contains(username)) {
                                name.add(username);
                                job_count.add(1);
                            }
                            else {
                                for (int k = 0; k < name.size(); k++) {
                                    if(username.equalsIgnoreCase(name.get(k))) {
                                        job_count.set(k, job_count.get(k) + 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\nTotal records read: " + no_of_records);
        System.out.println("*".repeat(30));
        
        System.out.println("Printing user submission stat: ");
        System.out.printf("%-20s%-50s\n", "User", "Jobs Submitted");
        System.out.printf("%-20s%-50s\n", "----", "--------------");
        for (int i = 0; i < name.size(); i++) {
            System.out.printf("%-20s%-5d\n" , name.get(i), job_count.get(i));
        }
        System.out.println("*".repeat(30));
        System.out.println("Print jobs status");
        System.out.printf("%-12s%-20s%-24s%-25s\n", "Job ID", "Submitted (queue)", "Started (start time)", "Exited (end time/ error)");
        System.out.printf("%-12s%-20s%-24s%-25s\n", "------", "-----------------", "--------------------", "------------------------");
        
        ArrayList<Integer> ignore = new ArrayList<>();
        
        outer:
        for (int i = 0; i < records.length; i++) {
            for (int j = 0; j < ignore.size(); j++) {
                if(i == ignore.get(j)){
                    continue outer;
                }
            }
            String submitted = "";
            String started = "";
            String exited = "";
            String queue = records[i][1];
            String type = queue.split(";")[1];
            String ID = queue.split(";")[2].split("\\.")[0];
            if(type.equalsIgnoreCase("Q")) {
                submitted = "Y " + "(" + queue.split(";")[3].split("=")[1] + ")";
                
                for (int j = i; j < records.length; j++) {
                    String s_line = records[j][1];
                    String[] s_line_values = s_line.split(";");
                    if(s_line_values[1].equalsIgnoreCase("S") && s_line_values[2].split("\\.")[0].equalsIgnoreCase(ID)) {
                        started = records[j][8].split("=")[1];
                        ignore.add(j);
                    }
                    else if (s_line_values[1].equalsIgnoreCase("E") && s_line_values[2].split("\\.")[0].equalsIgnoreCase(ID)) {
                        for (int k = 0; k < records[j].length; k++) {
                            if(records[j][k].substring(0, 4).equalsIgnoreCase("Exit")) {
                                
                                if(records[j][k].split("=")[1].equalsIgnoreCase("1")) {
                                    exited = records[j][k - 1].split("=")[1];
                                }
                                else {
                                    exited = "Error: " + records[j][k];
                                }
                            }
                        }
                        ignore.add(j);
                    }
                    
                }
            }
            System.out.printf("%-12s%-20s%-24s%-25s\n", ID, submitted, started, (exited.isEmpty() ? null : exited));
        }
    }
}
