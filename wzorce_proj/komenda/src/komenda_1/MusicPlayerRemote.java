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
public class MusicPlayerRemote {
    private MusicPlayerCommand command;

  
    public void setMuscicPlayerCommand(MusicPlayerCommand command) {
        this.command = command;
    }
    
    public void pressButton(){
        command.play();
    }
    
    
}
