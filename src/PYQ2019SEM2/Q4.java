/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2019SEM2;

/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        Pizza peperoni = new Pizza("Medium", 3, 2, 2);
        peperoni.display();
    }
}

class Pizza {
    private String size;
    private int numOfCheeseTopping;
    private int numOfBeefTopping;
    private int numOfChickenTopping;

    public Pizza(String size, int numOfCheeseTopping, int numOfBeefTopping, int numOfChickenTopping) {
        this.size = size;
        this.numOfCheeseTopping = numOfCheeseTopping;
        this.numOfBeefTopping = numOfBeefTopping;
        this.numOfChickenTopping = numOfChickenTopping;
    }

    public String getSize() {
        return size;
    }

    public int getNumOfCheeseTopping() {
        return numOfCheeseTopping;
    }

    public int getNumOfBeefTopping() {
        return numOfBeefTopping;
    }

    public int getNumOfChickenTopping() {
        return numOfChickenTopping;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setNumOfCheeseTopping(int numOfCheeseTopping) {
        this.numOfCheeseTopping = numOfCheeseTopping;
    }

    public void setNumOfBeefTopping(int numOfBeefTopping) {
        this.numOfBeefTopping = numOfBeefTopping;
    }

    public void setNumOfChickenTopping(int numOfChickenTopping) {
        this.numOfChickenTopping = numOfChickenTopping;
    }
    
    public double computeCost() {
        double total = 0;
        switch(size) {
            case "Small":
                total = 10 + 2 * (numOfCheeseTopping + numOfBeefTopping + numOfChickenTopping);
                break;
            case "Medium":
                total = 12 + 2 * (numOfCheeseTopping + numOfBeefTopping + numOfChickenTopping);
                break;
            case "Large":
                total = 14 + 2 * (numOfCheeseTopping + numOfBeefTopping + numOfChickenTopping);
                break;
        }
        return total;
    }
    
    public void display() {
        System.out.println("Pizza size: " + size);
        System.out.println("Toppings: ");
        System.out.println("Cheese: " + numOfCheeseTopping);
        System.out.println("Beef: " + numOfBeefTopping);
        System.out.println("Chicken: " + numOfChickenTopping);
        System.out.println("Cost: RM" + computeCost());
    }
}