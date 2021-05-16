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
public class TurboAmd extends Decorator{
    
    public TurboAmd(Processor processor){
        super(processor);
    }
    
    public void build(){
        processor.build();
        setTurbo(processor);
    }
    public void setTurbo(Processor processor){
        System.out.println("ustawiono turbo amd");
    }
}
