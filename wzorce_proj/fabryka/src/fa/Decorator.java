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
public abstract class Decorator implements Processor {
    
    protected Processor processor;
    
    public Decorator(Processor processor){
        this.processor= processor;
    }
    
    public void build(){
        processor.build();
    }
    
    
}
