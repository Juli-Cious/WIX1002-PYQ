/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PYQ2021SEM1;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author justb
 */
public class Q1 {

    public static void main(String args[]) {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("intvalues.dat"));
            obj.writeInt(802);
            obj.writeInt(190817);
            obj.writeInt(50346340);
        
            obj.close();
        
        } catch(IOException e) {
            
        }
        
        
        File file = new File("intvalues.dat");
        DivideF1 a = new DivideF1(file);
        DivideF2 b = new DivideF2(file);
        display(a);
        display(b);
    }
    
    public static void display(Eleven el) {
        System.out.println(el.divide());
    }
}

abstract class Eleven {
    int[] arr;
    File file;

    public Eleven(File file) {
        this.file = file;
        
        int size = 0;
        try { //getting size of array
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(this.file));
            while(true) {
                obj.readInt();
                size++;
            }
        } catch(EOFException e) {
            System.out.println("End of file reached. ");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        this.arr = new int[size];
        
        
        try { //populating array
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(this.file));
            int i = 0;
            while(true) {
                int value = obj.readInt();
                this.arr[i] = value; 
                i++;
            }
        } catch(EOFException e) {
            System.out.println("End of file reached.");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    abstract String divide();
}

class DivideF1 extends Eleven {

    public DivideF1(File file) {
        super(file);
    }
    
    public String divide() {
        
        String output = "Divisibility Rule (Formula 1)\n";
        for (int i = 0; i < this.arr.length; i++) {
            int sum_of_odd = 0;
            int sum_of_even = 0;
            
            int number = this.arr[i];
            int digit = 0;
            while(number != 0) {
                digit++;
                if(digit % 2 != 0) {
                    sum_of_odd += number % 10;
                    number /= 10;
                }
                else {
                    sum_of_even += number % 10;
                    number /= 10;
                }
            }

            int diff = sum_of_odd - sum_of_even;
            diff = Math.abs(diff);
            
            output += this.arr[i] + " : |x| = | (";
            int temp = digit;
            if(temp % 2 == 0) {
                temp--;
            }
            for (int j = temp; j > 0; j = j-2) {
                if(j == 2 || j == 1) {
                    output +=  (this.arr[i] /(int) Math.pow(10, (j - 1)) ) % 10 + ")";
                    break;
                }
                
                output +=  (this.arr[i] /(int) Math.pow(10, (j - 1))  ) % 10 + " + ";
                
            }
            
            output += " - (";
            if(digit % 2 != 0) {
                digit--;
            }
            for (int j = digit; j > 0; j = j-2) {
                 if(j == 2 || j == 1) {
                    output +=  (this.arr[i] /(int) Math.pow(10, (j - 1)) ) % 10 + ")";
                    break;
                }
                 
                output +=  (this.arr[i] /(int) Math.pow(10, (j - 1)) ) % 10 + " + ";
                
            }
            output += " | = " + diff + "\n";
            if(diff % 11 == 0) {
                output += diff + " modulus 11 = 0, " + this.arr[i] + " is divisible by 11.";
            }
            else {
                output += diff + " modulus 11 is not equal to 0, " + this.arr[i] + " is not divisible by 11.";
            }
            
            output += "\n\n";
        }
        
        return output;
    }
}

class DivideF2 extends Eleven {

    public DivideF2(File file) {
        super(file);
    }
    
    public String divide() {
        String output = "Divisibility Rule (Formula 2)\n";
        for (int i = 0; i < this.arr.length; i++) {
            
            int subject = this.arr[i];
            output += subject + " : ";
            while(subject >= 100) {
                output += (subject / 10) + " - " + (subject % 10) + " * 1 = ";
                subject = subject / 10 - (subject % 10);
                output += subject + ", ";
            }
            output += ", x = " + subject;
            
            if(subject % 11 == 0) {
                output += "\n" + subject + " modulus 11 = 0, " + this.arr[i] + " is divisible by 11";
            }
            else {
                output += "\n" + subject + " modulus 11 is not equal to 0, " + this.arr[i] + " is not divisible by 11";
            }
            
            output += "\n\n";
        }
        return output;
    }
    
}