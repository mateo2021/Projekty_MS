/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Adapter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UkDevice ukd = new UkDevice() {
            @Override
            public void turnOn() {
                System.out.println("Działa angielskie radnio");
            }
        };
          
        ContinentalDevice cd = new ContinentalDevice() {
            @Override
            public void on() {
                System.out.println("Dziala kontynentalne radio");
            }
        };
        
        
        UkSocket uks = new UkSocket();
        ContinentalSocket cs = new ContinentalSocket();
        
        
 
        UkToContinental uktc = new UkToContinental(ukd);
        
        uktc.on();
        
        
    }
    
}
