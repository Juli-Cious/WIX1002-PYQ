/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2019SEM1;

/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        double grand_total = 0;
        
        Delivery[] deliveries = {   new Delivery("Ali", "Ahmad", 4.4),
                                    new Delivery("Ah Chong", "Fatimah", 63.1),
                                    new SpecialDelivery(true, false, "FSKTM, UM", "FK, UM", 32.5),
                                    new SpecialDelivery(true, true, "Ang", "Liew", 19.0)    
                                };
        
        for (Delivery delivery : deliveries) {
            grand_total += delivery.totalCost();
            System.out.println(delivery.toString());
            System.out.println("");
        }
        System.out.println("The total shipping cost is RM " + grand_total);
        
    }
}

class Delivery {
    private String sender;
    private String recipient;
    protected double weight;

    public Delivery(String sender, String recipient, double weight) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
    }
    
    public double totalCost() {
        double weight = this.weight;
        double total_cost = 0;
        
        if(weight <= 5) {
            total_cost = weight * 2.8;
        }
        else if (weight <= 20) {
            total_cost = (5 * 2.8) + (weight - 5) * 5.2;
        }
        else if (weight <= 50) {
            total_cost = (5 * 2.8) + (15 * 5.2) + (weight - 20) * 7;
        }
        else {
            total_cost = (5 * 2.8) + (15 * 5.2) + (30 * 7) + (weight - 50) * 8.6;
        }
        
        return total_cost;
    }
    
    @Override
    public String toString() {
        return  "From: " + this.sender + " ||" +
                "To: " + this.recipient + 
                "\nWeight of package : " + this.weight + "kg" + 
                "\nTotal shipping cost: RM" + totalCost();
    }
}

class SpecialDelivery extends Delivery {
    private boolean weekend;
    private boolean nighttime;

    public SpecialDelivery(boolean weekend, boolean nighttime, String sender, String recipient, double weight) {
        super(sender, recipient, weight);
        this.weekend = weekend;
        this.nighttime = nighttime;
    }
    
    public double totalCost() {
        double weight = this.weight;
        double total_cost = 0;
        
        if(weight <= 5) {
            total_cost = weight * 2.8;
        }
        else if (weight <= 20) {
            total_cost = (5 * 2.8) + (weight - 5) * 5.2;
        }
        else if (weight <= 50) {
            total_cost = (5 * 2.8) + (15 * 5.2) + (weight - 20) * 7;
        }
        else {
            total_cost = (5 * 2.8) + (15 * 5.2) + (30 * 7) + (weight - 50) * 8.6;
        }
        
        if(this.weekend) {
            total_cost += 50;
        } 
        if (this.nighttime) {
            total_cost *= 1.2;
        }
        
        return total_cost;
    }
}


