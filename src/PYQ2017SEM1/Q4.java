/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2017SEM1;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("First complex number: ");
        System.out.print("Enter a number for the real part: ");
        double real_1 = sc.nextDouble();
        System.out.print("First complex number: ");
        System.out.print("Enter a number for the imaginary part: ");
        double imaginary_1 = sc.nextDouble();
        System.out.print("Second complex number: ");
        System.out.print("Enter a number for the real part: ");
        double real_2 = sc.nextDouble();
        System.out.print("Second complex number: ");
        System.out.print("Enter a number for the real imaginary: ");
        double imaginary_2 = sc.nextDouble();
        
        Complex first = new Complex(real_1, imaginary_1);
        Complex second = new Complex(real_2, imaginary_2);
        System.out.println("First complex number " + first.toString());
        System.out.println("Second complex number: " + second.toString());
        
        Complex add = first.addComplexNum(second);
        Complex subtract = first.subtractComplexNum(second);
        System.out.println("Addtion of the two complex numbers: " + add.toString());
        System.out.println("Subtraction of the two complex numbers: " + subtract.toString());
        
    }
}

class Complex {
    private double real;
    private double imaginary;
    
    Complex() {
        
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public Complex addComplexNum(Complex b) {
        double real_ans = this.real + b.real;
        double imaginary_ans = this.imaginary + b.imaginary;
        Complex ans = new Complex(real_ans, imaginary_ans);
        return ans;
    }
    
    public Complex subtractComplexNum(Complex b) {
        double real_ans = this.real - b.real;
        double imaginary_ans = this.imaginary - b.imaginary;
        Complex ans = new Complex(real_ans, imaginary_ans);
        return ans;
    }
    
    @Override
    public String toString() {
        return "(" + this.real + " + " + this.imaginary + "i)";
    }

}
