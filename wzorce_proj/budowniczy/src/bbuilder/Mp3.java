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
public class Mp3 implements MuzykaBuilder{
    
    private Muzyka muzyka;
    
    public Mp3(){
        this.muzyka = new Muzyka();
    }
    public void budujNalowek(){
        System.out.println("naglowek mp3");
    }
    public void budujTagi(){
        System.out.println("tagi mp3");
    }
    public void budujBody(){
        System.out.println("body mp3");
    }
    public Muzyka getMuzyka(){
        return muzyka;
    }

   
    
}
