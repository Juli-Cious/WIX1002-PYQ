/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM2;

/**
 *
 * @author justb
 */
public class Job {
    private String jobName;
    private String partition;
    private String memory;
    private String qos;
    
    Job(String jobName, String partition, String memory, String qos) {
        this.jobName = jobName;
        this.partition = partition;
        this.memory = memory;
        this.qos = qos;
    }

    public String getJobName() {
        return jobName;
    }

    public String getPartition() {
        return partition;
    }

    public String getMemory() {
        return memory;
    }

    public String getQos() {
        return qos;
    }
    
    
}
