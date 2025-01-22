/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PYQ2019SEM2;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q6 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Customer name: ");
        String name = sc.next();
        System.out.print("Enter customer id: " );
        String id = sc.next();
        System.out.print("Enter quantity ordered: ");
        int quantity = sc.nextInt();
        System.out.print("Enter price per unit: ");
        double unit_price = sc.nextDouble();
        
        System.out.println("");
        Order order1 = new Order(name, id, quantity, unit_price);
        System.out.println(order1.toString());
        System.out.println("");
        ShippedOrder order2 = new ShippedOrder("joe", "123", 10, 5);
        System.out.println(order2.toString());
        
    }
}

class Order {
    private String customer_name;
    private String customer_ID;
    private int quantity_ordered;
    private double unit_price;
    
    Order() {
        this.customer_name = "Jane Doe";
        this.customer_ID = "0";
        this.quantity_ordered = 0;
        this.unit_price = 0;
    }

    public Order(String customer_name, String customer_ID, int quantity_ordered, double unit_price) {
        this.customer_name = customer_name;
        this.customer_ID = customer_ID;
        this.quantity_ordered = quantity_ordered;
        this.unit_price = unit_price;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public int getQuantity_ordered() {
        return quantity_ordered;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public void setQuantity_ordered(int quantity_ordered) {
        this.quantity_ordered = quantity_ordered;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double computeTotalPrice() {
        return quantity_ordered * unit_price;
    }
    
    @Override
    public String toString() {
        String description = "Order record" +
                "\nName: " + getCustomer_name() +
                "\nID: " + getCustomer_ID() +
                "\nQuantity: " + getQuantity_ordered() + 
                "\nUnit price: " + getUnit_price() +
                "\nTotal price: " + computeTotalPrice();
        
        return description;
    }
}

class ShippedOrder extends Order {
    @Override
    public double computeTotalPrice() {
        return getQuantity_ordered() * getUnit_price() + 4;
    }
    
    ShippedOrder(String customer_name, String customer_ID, int quantity_ordered, double unit_price) {
        super(customer_name, customer_ID, quantity_ordered, unit_price);
    }
    
    public String toString() {
        String description = "Shipped" +
                "\nName: " + getCustomer_name() +
                "\nID: " + getCustomer_ID() +
                "\nQuantity: " + getQuantity_ordered() + 
                "\nUnit price: " + getUnit_price() +
                "\nTotal price: " + computeTotalPrice();
        
        return description;
    }
}