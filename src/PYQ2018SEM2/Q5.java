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
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the marks for Grammar (maximum 30 marks) : ");
        int grammar = sc.nextInt();
        System.out.print("Enter the marks for Spelling (maximum 20 marks) : ");
        int spelling = sc.nextInt();
        System.out.print("Enter the marks for Length (maximum 20 marks) : ");
        int length = sc.nextInt();
        System.out.print("Enter the marks for Content (maximum 30 marks) : ");
        int content = sc.nextInt();
        System.out.println("");
    
        Essay essay1 = new Essay(grammar, spelling, length, content);
        essay1.setScore(grammar + spelling + length + content);
        
        System.out.println(essay1.toString());
    }
    
}

class GradedActivity {
    private int numeric_score;
    
    public void setScore(int numeric_score) {
        this.numeric_score = numeric_score;
    }
    
    public int getScore() {
        return this.numeric_score;
    }
    
    public char getGrade() {
        if(this.numeric_score >= 90) {
            return 'A';
        }
        else if(this.numeric_score >= 80) {
            return 'B';
        }
        else if(this.numeric_score >= 70) {
            return 'C';
        }
        else if(this.numeric_score >= 60) {
            return 'D';
        }
        else {
            return 'F';
        }
    }
    
    @Override
    public String toString() {
        return "Total score: " + getScore() + "\nEssay grade: " +  getGrade();
    }
}

class Essay extends GradedActivity {
    private int grammar, spelling, length, content;

    public Essay(int grammar, int spelling, int length, int content) {
        this.grammar = grammar;
        this.spelling = spelling;
        this.length = length;
        this.content = content;
    }
    
    public String toString() {
        return  "Essay score: \n" +
                "Grammar: " + this.grammar +
                "\nSpelling: " + this.spelling +
                "\nLength: " + this.length +
                "\nContent: " + this.content +
                "\n\n" + super.toString();
    }
}
