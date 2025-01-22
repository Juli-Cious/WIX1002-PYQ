/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2019SEM2;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of a,b and c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        QuadraticEquation tester = new QuadraticEquation(a, b, c);
    
        System.out.printf("The equation is: %fx(^2) + (%f)x + (%f)\n", a, b, c);
        System.out.println("Discriminant: " + tester.Discriminant());
        
        if(tester.Discriminant() > 0) {
            System.out.printf("The roots : %f and %f\n", tester.calcRoot1(), tester.calcRoot2());
        }
        else if (tester.Discriminant() == 0) {
            System.out.println("Same roots: " + tester.calcRoot1());
        }
        else {
            System.out.println("The equation has no roots.");
        }
    }
}

class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    
    public double Discriminant() {
        return b * b - 4 * a * c;
    }
    
    public double calcRoot1() {
        if(Discriminant() < 0) {
            return 0;
        }
        double r1 = (-b + Math.sqrt(Discriminant())) / (2 * a);
        return r1;
    }
    
    public double calcRoot2() {
        if(Discriminant() < 0) {
            return 0;
        }
        double r2 = (-b - Math.sqrt(Discriminant())) / (2 * a);
        return r2;
    }
}
