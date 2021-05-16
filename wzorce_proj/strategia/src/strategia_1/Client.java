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
public class Client {
    private static final String tte ="Show Me love";
    
    
    public static void main(String[] args){
        
        TextInterfaceContext tic = new TextInterfaceContext();
        
        tic.set(new LowerCase());
        tic.print(tte);
        
        tic.set(new CapitalizeText());
        tic.print(tte);
        
        
        
    }
    
}
