/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad_kol;

/**
 *
 * @author Mateusz Stadnicki
 */
public class pliki_txt implements KalalogiInterface{
    private String nazwa;
    private int rozmiar;

    public pliki_txt(String nazwa, int rozmiar) {
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
    }

    @Override
    public void show() {
        System.out.println("nazwa :"+ nazwa + " rozmiar: "+ rozmiar);
    }

    
    
    
    
    
}
