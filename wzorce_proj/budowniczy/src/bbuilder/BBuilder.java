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
public class BBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Wav wav = new Wav();
        Mp3 mp3 = new Mp3();
        
        MuzykaDirector dir = new MuzykaDirector(mp3);
        
        MuzykaDirector dir1 = new MuzykaDirector(wav);
        
        dir.budujMuzyka();
        
        dir1.budujMuzyka();
    }
    
}
