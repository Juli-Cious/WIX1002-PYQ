/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017SEM2;

/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        PermanentStaff p1 = new PermanentStaff("Abdul Razak", "871001-14-1765", "EM02");
        PartTimeStaff p2 = new PartTimeStaff("Tengku Ali", "911223-08-3301", 35);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}

class Staff {
    private String name;
    private String IC;

    public Staff(String name, String IC) {
        this.name = name;
        this.IC = IC;
    }
    
    @Override
    public String toString() {
        return "Full Name: " + this.name + "\nIC: " + this.IC + "\n";
    }
}

class PermanentStaff extends Staff {
    private String grade;

    public PermanentStaff(String name, String IC, String grade) {
        super(name, IC);
        this.grade = grade;
    }
    
    public int getSalary() {
        switch(this.grade) {
            case "EM01" :
                return 7000;
            case "EM02" :
                return 5000;
            case "EM03" :
                return 3000;
            case "EM04" :
                return 1000;
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Grade: " + this.grade + "\nSalary: RM" + getSalary() + "\n";
    }
}

class PartTimeStaff extends Staff {
    private int hours;

    public PartTimeStaff(String name, String IC, int hours) {
        super(name, IC);
        this.hours = hours;
    }
    
    public int getSalary() {
        return this.hours * 40;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Number of working hours: " + this.hours + "\nSalary: RM" + getSalary() + "\n";
    }
}