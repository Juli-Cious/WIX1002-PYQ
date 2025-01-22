/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2020SEM1;

/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        Job j1 = new Job("J1", 252, 20);
        Job j2 = new Job("J2", 108, 10);
        Job j3 = new Job("J3", 72, 25);
        Job[] job_array = {j1, j2, j3};
        CloudPackage[] cloud = {  new CloudPackage(4, 15, 1.24, "P2-15"),
                                  new CloudPackage(6, 30, 2.11, "P2-30"),
                                  new CloudPackage(4, 20, 1.38, "P5-20"),
                                  new CloudPackage(6, 20, 1.88, "P6-20") };
    
        double total = 0;
        for (Job j : job_array) {
            double min = Double.MAX_VALUE;
            int min_index = 0;
            for (int i = 0; i < cloud.length; i++) {
                if(!cloud[i].check(j)) {
                   continue;
                }
                cloud[i].totalCost(j);
                if(cloud[i].getTotal_cost() < min) {
                    min = cloud[i].getTotal_cost();
                    min_index = i;
                }
            }
            System.out.println(j.toString());
            System.out.println(cloud[min_index].toString());
            System.out.println("");
            total += min;
        }
        System.out.println("Total cost: " + total);
    }
}

class Cloud {
    private String cloud_package;
    protected double total_cost;

    public double getTotal_cost() {
        return total_cost;
    }

    public Cloud(String cloud_package) {
        this.cloud_package = cloud_package;
    }

    @Override
    public String toString() {
        return "Cloud_package = " + cloud_package + ", total_cost = " + total_cost;
    }
    
    
}

class CloudPackage extends Cloud {
    private int cores;
    private int memory;
    private double price_per_hour;

    public CloudPackage(int cores, int memory, double price_per_hour, String cloud_package) {
        super(cloud_package);
        this.cores = cores;
        this.memory = memory;
        this.price_per_hour = price_per_hour;
    }
    
    public boolean check(Job job) {
        return job.getMemory() <= this.memory;
    }
    
    public void totalCost(Job job) {
            int tasks_per_hour = 1 * cores;
            double price = job.getTasks() / tasks_per_hour * price_per_hour;
            this.total_cost = price;
    }
}

class Job {
    private String name;
    private int tasks;
    private int memory;

    public Job(String name, int tasks, int memory) {
        this.name = name;
        this.tasks = tasks;
        this.memory = memory;
    }

    public String getName() {
        return name;
    }

    public int getTasks() {
        return tasks;
    }

    public int getMemory() {
        return memory;
    }
    
    @Override
    public String toString() {
        return  "Name: " + getName() +
                ", Memory: " + getMemory() +
                ", Number of tasks: " + getTasks();
    }
}
