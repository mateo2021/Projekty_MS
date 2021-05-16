/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komenda_1;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Komenda_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MusicPlayer mp = new MusicPlayer();
        MusicPlayerRemote remote = new MusicPlayerRemote();
        
        remote.setMuscicPlayerCommand(new MusicFirstTrack(mp));
        remote.pressButton();
        
        
         remote.setMuscicPlayerCommand(new MusicNextTrack(mp));
         remote.pressButton();
         remote.pressButton();
         remote.pressButton();
        
        
    }
    
}
