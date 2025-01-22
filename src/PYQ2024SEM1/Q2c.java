/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM1;

/**
 *
 * @author justb
 */
public class Q2c {
    public static void main(String[] args) {
        Playable[] instruments = {  new Guitar(),
                                    new Guitar(),
                                    new Piano(),
                                    new Guitar(),
                                    new Piano() 
                                 };
        
        for(Playable n : instruments) {
            n.play();
        }
    }
}

interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Pluck Strings!");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Press notes!");
    }
}