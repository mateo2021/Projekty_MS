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
public class ShapeDecorator implements shape{
    protected shape sh;
    
    
    public ShapeDecorator(shape sh){
        this.sh = sh;
    }
    @Override
    public void draw(){
        sh.draw();
    }
}
