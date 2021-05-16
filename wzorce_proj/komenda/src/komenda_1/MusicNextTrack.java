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
public class MusicNextTrack implements MusicPlayerCommand{
    private MusicPlayer music;
    
    public MusicNextTrack(MusicPlayer music){
        this.music = music;
    }
    
    @Override
    public void play(){
        music.playNextTrack();
    }
    
}
