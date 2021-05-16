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
public class UkToContinental implements ContinentalDevice{
    
    UkDevice device;

    public UkToContinental(UkDevice device) {
        this.device = device;
    }

    
    @Override
    public void on() {
       device.turnOn();
    }
    
    
}
