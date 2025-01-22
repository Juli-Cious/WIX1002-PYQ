/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016SEM1;

/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        Rebate r = new Rebate("John Lim", "1111222233334444");
        Point p = new Point("John Lim", "5555666677778888");
        
        String[] type = {"Grocery", "Other", "Fuel", "Utility", "Other"};
        String[] day = {"Saturday", "Friday", "Sunday", "Friday", "Tuesday"};
        double[] total = {124.8, 64.60, 95.4, 100, 220};
        
        
        double rebate = r.getReward(type, total);
        double point = p.getReward(day, total);
        r.setTotalReward(rebate);
        p.setTotalReward(point);
        System.out.println(r.toString());
        System.out.println(p.toString());
        
        System.out.println("The best card is ");
        if(rebate > point) {
            System.out.println("Cash Rebate Card.");
        }
        else if (point > rebate){
            System.out.println("Point Reward Card.");
        }
        else {
            System.out.println("Both's the same.");
        }
        
    }
}

class CreditCard {
    private String name;
    private String number;
    protected String type;
    private double totalReward;

    public CreditCard(String name, String number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }

    public double getTotalReward() {
        return totalReward;
    }

    public void setTotalReward(double totalReward) {
        this.totalReward = totalReward;
    }
    
    public String toString() {
        String info = "Name: " + this.name
                    + " (" + this.number + ") "
                    + "\nType: " + this.type
                    + "\nTotal reward: " + this.totalReward
                    + "\n";
        return info;
    }
    
}

class Rebate extends CreditCard {

    public Rebate(String name, String number) {
        super(name, number, "Cash Rebate");
    }
    
    public double getReward(String[] type, double[] total) {
        double totalReward = 0;
        
        for (int i = 0; i < type.length; i++) {
            switch(type[i]) {
                case "Fuel":
                    totalReward += total[i] * 0.08;
                    break;
                case "Utility":
                    totalReward += total[i] * 0.05;
                    break;
                case "Grocery":
                    totalReward += total[i] * 0.02;
                    break;
                case "Other":
                    totalReward += total[i] * 0.002;
                    break;
                default:
                    System.out.println("Invalid type.");
                    break;
            }
        }
        
        return totalReward;
    }
    
}

class Point extends CreditCard {

    public Point(String name, String number) {
        super(name, number, "Point Reward");
    }
    
    public double getReward(String[] type, double[] total) {
        double totalReward = 0;
        
        for (int i = 0; i < type.length; i++) {
            switch(type[i]) {
                case "Friday":
                    totalReward += (int) total[i] * 2;
                    break;
                case "Saturday":
                    totalReward += (int) total[i] * 3;
                    break;
                case "Sunday":
                    totalReward += (int) total[i] * 4;
                    break;
                default:
                    totalReward += (int) total[i];
                    break;
            }
        }
        
        totalReward = totalReward / 100.0;
        return totalReward;
    }
}