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
public class Dekorator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     shape circle = new Circle();
     shape rectangle = new Rectangle();
     
    RedShapeDecorator redr = new RedShapeDecorator(rectangle);
    BlackFillDecorator blackr = new BlackFillDecorator(rectangle);
      
      
//    circle.draw();
//    BlackFillDecorator blackc = new BlackFillDecorator(circle);
//    blackc.draw();
//    
    
    rectangle.draw();
    redr.draw();
    blackr.draw();
    
     
    
    
    }
    
}
