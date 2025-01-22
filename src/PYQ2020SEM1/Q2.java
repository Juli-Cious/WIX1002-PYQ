/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2020SEM1;

import java.util.Scanner;

/**
 *
 * @author justb
 */
public class Q2 {
    public static void main(String[] args) {
        double distance = calcDistance();
        System.out.println("Distance : " + distance + "KM");
    }
    
    public static double[] promptInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter direction: ");
        char direction = sc.next().charAt(0);
        System.out.print("Enter degree, minute, second : ");
        double degree = sc.nextDouble();
        double minute = sc.nextDouble();
        double second = sc.nextDouble();
        
        double[] values = {(double) direction, degree, minute, second};
        return values;
    }
    
    public static String calcDecimalDegree(double[] data) {
        char direction = (char) data[0];
        double degree = data[1];
        double minute = data[2];
        double second = data[3];
        
        double decimalDegree = 0;
        if(direction == 'N' || direction == 'E') {
            decimalDegree = + degree + (minute * 60 + second) / 3600;
        } 
        else if(direction == 'S' || direction == 'W') {
            decimalDegree = -(degree + (minute * 60 + second) / 3600);
        }
        
        String type;
        if(direction == 'N' || direction == 'S') {
            type = "Latitude";
        }
        else {
            type = "Longitude";
        }
        return String.valueOf(decimalDegree) + " " + type;
    }
    
    public static double calcDistance() {
        System.out.println("Enter location 1: ");
        double[] location1_Lati_data = promptInput(); //Latitude
        double[] location1_Longi_data = promptInput(); //Longitude
        System.out.println("Enter location 2: ");
        double[] location2_Lati_data = promptInput(); //Latitude
        double[] location2_Longi_data = promptInput(); //Longitude
        
        String location1_Lati = calcDecimalDegree(location1_Lati_data);
        String location1_Longi = calcDecimalDegree(location1_Longi_data);
        String location2_Lati = calcDecimalDegree(location2_Lati_data);
        String location2_Longi = calcDecimalDegree(location2_Longi_data);
        System.out.println(location1_Lati);
        System.out.println(location1_Longi);
        System.out.println(location2_Lati);
        System.out.println(location2_Longi);
        
        double lati1 = Double.parseDouble(location1_Lati.split(" ")[0]);
        double longi1 = Double.parseDouble(location1_Longi.split(" ")[0]);
        double lati2 = Double.parseDouble(location2_Lati.split(" ")[0]);
        double longi2 = Double.parseDouble(location2_Longi.split(" ")[0]);
        
        //converting to radians
        lati1 = lati1 * (Math.PI / 180);
        longi1 = longi1 * (Math.PI / 180);
        lati2 = lati2 * (Math.PI / 180);
        longi2 = longi2 * (Math.PI / 180);
        
        double diff_lati = lati1 - lati2;
        double diff_longi = longi1 - longi2;
        
        double a = Math.pow(Math.sin((diff_lati) / 2), 2) + Math.cos(lati1) * Math.cos(lati2) * Math.pow(Math.sin(diff_longi / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return 6371 * c;
    }
}
