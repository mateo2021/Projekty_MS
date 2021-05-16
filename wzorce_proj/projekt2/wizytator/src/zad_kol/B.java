/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad_kol;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz Stadnicki
 */
public class B implements KalalogiInterface,Visit{
    private String nazwa;

    public B(String nazwa) {
        this.nazwa = nazwa;
    }
    
    List<KalalogiInterface> queue = new ArrayList<KalalogiInterface>();
    
    public void add(KalalogiInterface add){
     queue.add(add);
    }
     public int suma_plikow(){
        int suma_plikow = queue.size();
        return suma_plikow;
    }
    
    @Override
    public void show() {
        System.out.println("nazwa:" + nazwa);
        for(KalalogiInterface k:queue){
            k.show();
        }
    }

    @Override
    public void accept(Visitator visitator) {
       visitator.visit(this);
    }
    
}
