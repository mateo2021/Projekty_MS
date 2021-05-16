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
public class VisitatorLiczbaPlikow implements Visitator{
    private  int suma = 1;

    @Override
    public void visit(Korzen korzen) {
      suma += korzen.suma_plikow();
        System.out.println(suma);
    }

    @Override
    public void visit(B b) {
      suma+= b.suma_plikow();
      System.out.println(suma);
    }

    @Override
    public void visit(A a) {
        suma+= a.suma_plikow();
        System.out.println(suma);
    }
    
    
    
}
