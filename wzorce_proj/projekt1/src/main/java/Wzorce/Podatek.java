package Wzorce;

public class Podatek {
    private PodatekStrategia strategy;
 
     public void setPodatekStrategia(PodatekStrategia  strategy) {
         this.strategy = strategy;
     }
     
     
 
     public double podaj(double kwota) {
        Double kwotapodatku = strategy.Evaluate(kwota);
        return kwotapodatku;
     }
}
