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
public class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator (shape sh){
        super(sh);
    }
    @Override
    public void draw(){
        setRedBorder(sh);
    }
    
    private void setRedBorder(shape sh){
        System.out.println("Border red");
    }
    
}
