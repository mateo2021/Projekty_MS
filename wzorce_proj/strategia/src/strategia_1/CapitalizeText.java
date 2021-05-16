/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategia_1;

/**
 *
 * @author Mateusz Stadnicki
 */
public class CapitalizeText implements TextInterface {
    public String format(String text){
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }
    
}
