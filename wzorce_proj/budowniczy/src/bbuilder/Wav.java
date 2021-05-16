/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbuilder;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Wav implements MuzykaBuilder{
    
    private Muzyka muzyka;
    
    public Wav(){
    this.muzyka = new Muzyka();
    }

    @Override
    public void budujNalowek() {
        System.out.println("naglowek wav");
    }

    @Override
    public void budujTagi() {
        System.out.println("tagi wav");
    }

    @Override
    public void budujBody() {
        System.out.println("body wav");
    }

    @Override
    public Muzyka getMuzyka() {
       return muzyka;
    }
    
    
    
}
