/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komenda_1;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mateusz Stadnicki
 */
public class MusicPlayer {
    private List<String> tracks = Arrays.asList("Track 1","Track 2","Track 3");
    private int currentTrackNumber = 0;
    
    
    public void playFirstTrack(){
        System.out.println("Gram pierwszy utwór: " + tracks.get(0)); 
    }
    public void playNextTrack(){
        currentTrackNumber ++;
        if(currentTrackNumber>2){
           currentTrackNumber = 0;
        }          
         System.out.println("Przełączam na kolejny:" +tracks.get(currentTrackNumber));
        
    }
    
    public void playRandomTrack() {
        int randomTrackNumber = (int) (Math.random() * (3));
        System.out.println("Gram losowy utwór: " + tracks.get(randomTrackNumber));
    }
    
}
