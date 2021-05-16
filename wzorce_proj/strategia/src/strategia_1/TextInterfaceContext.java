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
public class TextInterfaceContext {
    
    private TextInterface strategy;
    
    public void set(TextInterface strategy){
        this.strategy=strategy;
    }
    
    public void print(String text){
        String newText = strategy.format(text);
        System.out.println(newText);
    }
    
}
