/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016SEM2;

/**
 *
 * @author justb
 */
public class Q6 {
    public static void main(String[] args) {
        FinancialRecord record_A = new FinancialRecord(1234, 10000);
        record_A.setAnnualInterestRate(7.77);
        
        System.out.println("The information about financial record A is as follows: ");
        record_A.displayRecordInfo();
        System.out.println("");
    
        FinancialRecord record_B = new FinancialRecord(1235, 20000);
        record_B.setAnnualInterestRate(8);
        System.out.println("The information about financial record B is as follows: ");
        record_B.displayRecordInfo();
        
        System.out.println("The monthly interest rate is: " + record_B.getMonthlyInterestRate());
        record_B.deposit(1500);
        record_B.withdraw(500);
        
    }
}

class FinancialRecord {
    private int id;
    private double balance;
    private double annualInterestRate;

    public FinancialRecord() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
    }

    public FinancialRecord(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }
    
    public void withdraw(double amount) {
        System.out.println("Previous balance: RM" + this.balance);
        this.balance -= amount;
        System.out.println("Current balance after withdrawal of RM" + amount + " is: RM" + this.balance);
    }
    
    public void deposit(double amount) {
        System.out.println("Previous balance: RM" + this.balance);
        this.balance += amount;
        System.out.println("Current balance after deposit of RM" + amount + " is: RM" + this.balance);
    }
    
    public void displayRecordInfo() {
        System.out.println("Financial record id is: " + this.id);
        System.out.println("Financial record balance is: RM" + this.balance);
        System.out.println("Annual interest rate is: " + this.annualInterestRate);
    }
}
