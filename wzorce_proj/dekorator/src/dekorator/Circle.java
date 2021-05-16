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
public class Circle implements shape{
    
    @Override
    public void draw(){
        System.out.println("narysowano kolo");  
    }
}
