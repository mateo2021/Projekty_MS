/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorator;

/**
 *
 * @author Mateusz Stadnicki
 */
public class BlackFillDecorator extends ShapeDecorator {
        
    public BlackFillDecorator(shape sh){
        super(sh);
    }
    
    @Override
    public void draw(){
         setBlackFill(sh);
        
    }
    
    public void setBlackFill(shape sh){
        System.out.println(" czarne wypelnienie");
    }
    
}
