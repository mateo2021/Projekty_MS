/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Car {
    private Processor procesor;
    
    public Car(Processor processor){
        this.procesor = processor;
        
        process();
    }
    
    public void process(){
        procesor.build();
    }
    
}
