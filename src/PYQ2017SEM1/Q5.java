/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PYQ2017SEM1;
import java.util.Scanner;
/**
 *
 * @author justb
 */

//Graded Activity class
// numeric score,
//methods: setScore, getScore, getGrade, toString
// 


public class Q5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the marks for Grammar (maximum 30 marks): ");
        int grammar = sc.nextInt();
        System.out.print("Enter the marks for Spelling (maximum 20 marks): ");
        int spelling = sc.nextInt();
        System.out.print("Enter the marks for Length (maximum 20 marks): ");
        int length = sc.nextInt();
        System.out.print("Enter the marks for Content (maximum 30 marks): ");
        int content = sc.nextInt();
        
        Essay stud1 = new Essay(grammar, spelling, length, content);
        stud1.setScore(grammar + spelling + length + content);
        System.out.println("");
        
        System.out.println(stud1.toString());
        System.out.println("");
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
    
    public char getGrade(int score) {
        if(score >= 90) {
            return 'A';
        }
        else if (score >= 80) {
            return 'B';
        }
        else if (score >= 70) {
            return 'C';
        }
        else if (score >= 60) {
            return 'D';
        }
        else {
            return 'F';
        }
    }
    
    @Override
    public String toString() {
        return "Total score: " + this.numeric_score + "\nEssay grade: " + getGrade(this.numeric_score);
    }
}

class Essay extends GradedActivity {
    private int grammar;
    private int spelling;
    private int length;
    private int content;

    public Essay(int grammar, int spelling, int length, int content) {
        this.grammar = grammar;
        this.spelling = spelling;
        this.length = length;
        this.content = content;
    }
    
    @Override
    public String toString() {
        return  "Essay score: " 
                +"\nGrammar: " + this.grammar
                +"\nSpelling: " + this.spelling
                +"\nLength: " + this.length
                +"\nContent: " + this.content
                +"\n" + super.toString();
    }
}
