/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2018SEM1;

/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        Apple red_apple = new Apple(8, "red");
        Apple green_apple = new Apple(11, "green");

        Watermelon melon1 = new Watermelon(7.6, "local");
        Watermelon melon2 = new Watermelon(4, "imported");
        
        System.out.println(red_apple.toString() + "\n");
        System.out.println(green_apple.toString() + "\n");
        System.out.println(melon1.toString() + "\n");
        System.out.println(melon2.toString() + "\n");
        
        System.out.println("The cheapest item is: ");
        Fruit[] fruits = {red_apple, green_apple, melon1, melon2};
        
        double min = Double.MAX_VALUE;
        int max_index = 0;
        for (int i = 0; i < fruits.length; i++) {
            double price = fruits[i].totalPrice();
            if(price < min) {
                min = price;
                max_index = i;
            }
        }
        
        System.out.println(fruits[max_index].toString());
        
    }
}

abstract class Fruit {
    private String name;
    private String type;

    public Fruit(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    abstract public double totalPrice();

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + "\nType: " + this.type;
    }
}

class Apple extends Fruit {
    private int quantity;

    public Apple(int quantity, String type) {
        super("Apple", type);
        this.quantity = quantity;
    }
    
    @Override
    public double totalPrice() {
        if(super.getType().equalsIgnoreCase("Green")) {
            return this.quantity * 1.2;
        }
        else {
            return this.quantity * 1.8;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nTotal price: RM" + this.totalPrice();
    }
}

class Watermelon extends Fruit {
    private double weight;

    public Watermelon(double weight, String type) {
        super("Watermelon", type);
        this.weight = weight;
    }
    
    public double totalPrice() {
        double totalPrice = 0;
        if(super.getType().equalsIgnoreCase("Local") && weight < 2) {
            totalPrice = this.weight * 2.25;
        }
        else if (super.getType().equalsIgnoreCase("Local") && weight <= 5) {
            totalPrice = this.weight * 1.95;
        }
        else if (super.getType().equalsIgnoreCase("Local") && weight > 5) {
            totalPrice = this.weight * 1.65;
        }
        else if(super.getType().equalsIgnoreCase("Imported") && weight < 2) {
            totalPrice = this.weight * 3.75;
        }
        else if (super.getType().equalsIgnoreCase("Imported") && weight <= 5) {
            totalPrice = this.weight * 3.45;
        }
        else if (super.getType().equalsIgnoreCase("Imported") && weight > 5) {
            totalPrice = this.weight * 3.15;
        }
        
        return totalPrice;
    }
    
    public String toString() {
        return super.toString() + "\nWeight (kg): " + this.weight + "\nTotal price: RM" + totalPrice();
    }
}