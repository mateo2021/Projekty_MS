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
public class AmdFabric implements Fabric{
    
    public Processor build(){
        return new AmdProcessor();
    }
}
