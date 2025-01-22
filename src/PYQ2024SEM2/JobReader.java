/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM2;
import java.util.*;
import java.io.*;

/**
 *
 * @author justb
 */
public class JobReader {
    public static void main(String[] args) {
        Job[] jobs = readJobsFromDirectory(new File("C:/Users/justb/OneDrive/Desktop/JUSTTEST"));
        // change directory
        
        listAllJobs(jobs);
        generateStatistics(jobs);
    }
    
    public static Job[] readJobsFromDirectory(File input) {
        File[] files = input.listFiles();

        Job[] jobs = new Job[files.length];
        try {
           for(int i = 0; i < files.length; i++) {
                Scanner sc = new Scanner(new FileInputStream(files[i].getAbsolutePath()));
                
                String name = sc.nextLine().split(" ")[1];
                String partition = sc.nextLine().split(" ")[1];
                String memory = sc.nextLine().split(" ")[1];
                String qos = sc.nextLine().split(" ")[1];
                
                jobs[i] = new Job(name, partition, memory, qos);
           }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return jobs;
    }
    
    public static void listAllJobs(Job[] jobs) {
        for (Job job : jobs) {
            System.out.print("Job Name: " + job.getJobName());
            System.out.print(", Partition: " + job.getPartition());
            System.out.print(", Memory: " + job.getMemory());
            System.out.print(", QoS: " + job.getQos());
            System.out.println("");
        }
    }
    
    public static void generateStatistics(Job[] jobs) {
        int gpu_a = 0, gpu_v = 0, cpu = 0;
        int normal = 0, debug = 0, longer = 0;
        
        for(Job job : jobs) {
            String partition = job.getPartition();
            switch(partition) {
                case "gpu-a100":
                    gpu_a++;
                    break;
                case "gpu-v100s":
                    gpu_v++;
                    break;
                case "cpu-epyc-genoa":
                    cpu++;
                    break;
            }
            
            String qos = job.getQos();
            switch(qos){
                case "normal":
                    normal++;
                    break;
                case "debug":
                    debug++;
                    break;
                case "long":
                    longer++;
                    break;
            }
        }
        
        System.out.println("Partition Statistics: ");
        System.out.println("gpu-a100: " + gpu_a + " jobs");
        System.out.println("gpu-v100s: " + gpu_v + " jobs");
        System.out.println("cpu-epyc-genoa: " + cpu + " jobs");
        
        System.out.println("Qos Statistics: ");
        System.out.println("normal: " + normal + " jobs");
        System.out.println("debug: " + debug + " jobs");
        System.out.println("long: " + longer + " jobs");
    }
}
