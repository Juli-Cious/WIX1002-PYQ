/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2018SEM2;
import java.util.Scanner;
/**
 *
 * @author justb
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the values fo a, b, c, d, e and f : ");
        int a, b, c, d, e, f;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        e = sc.nextInt();
        f = sc.nextInt();
    
        LinearEquation abc = new LinearEquation(a, b, c, d, e, f);
        System.out.println("The equation");
        System.out.println(abc.toString());
        
        System.out.println("x = " + abc.computeX() + ", y = " + abc.computeY());
    }
}

class LinearEquation {
    private int a, b, c, d, e, f;

    public LinearEquation(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public String toString() {
        String eq = "%dx + %dy = %d\n%dx + %dy = %d";
        return eq.formatted(this.a, this.b, this.c, this.d, this.e, this.f);
    }
    
    public boolean isSolvable() {
        return (this.a * this.d - this.b * this.c) != 0;
    }
    
    public double computeX() {
        double x = (this.e * this.d - this.b * this.f)/(this.a * this.d - this.b * this.c);
        return x;
    }
    
    public double computeY() {
        double y = (this.a * this.f - this.e * this.c) / (this.a * this.d - this.b * this.c);
        return y;
    }
}
