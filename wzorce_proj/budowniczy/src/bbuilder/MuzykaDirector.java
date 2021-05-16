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
public class MuzykaDirector {
    private MuzykaBuilder builder;

    public MuzykaDirector(MuzykaBuilder builder) {
        this.builder=builder;
    }
    
    public void budujMuzyka(){
        builder.budujNalowek();
        builder.budujTagi();
        builder.budujBody();
    }
    
   public Muzyka getMuzyka(){
       return this.builder.getMuzyka();
   } 
    
    
    
    
}
