

package zaliczenie;

import java.io.IOException;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Gpanel extends JPanel{
    private final Zlecenie[] zlecenia;
    private int liczbaZlecen;
    private final Zlecenie[] zlecenia2;
    private int liczbaZlecen2;
    private final Zlecenie[] zlecenia3;
    private int liczbaZlecen3;
            
    
public Gpanel() {
        
        zlecenia = new Zlecenie[100];
        liczbaZlecen = 0;
        zlecenia2 = new Zlecenie[100];
        liczbaZlecen2 = 0;
        zlecenia3 = new Zlecenie[100];
        liczbaZlecen3 = 0;
        
        
        
    }
public void error(){
    
    final JPanel panel = new JPanel();
    JOptionPane.showMessageDialog(panel, "Złe dane", "Error!", JOptionPane.ERROR_MESSAGE);
     
}

    public void dodajZlecenie(Zlecenie zlecenie) {
       zlecenia[liczbaZlecen] = zlecenie;
       liczbaZlecen++;
    }
   
    public void usunZlecenie(int nr) {
          for(int i = nr; i < liczbaZlecen - 1; i++){
            zlecenia[i] = zlecenia[i + 1];
        }
        zlecenia[liczbaZlecen - 1] = null;
        liczbaZlecen--;
    }


    public String listaZlecen() {
        String wynik = "LISTA ZLECEŃ: ";
        for(int i = 0; i < liczbaZlecen; i++){
            wynik += "\n" + (i + 1) + ".  " + zlecenia[i];
        }
        return wynik;
    }
    public String Historia() {
        String wynik = "HISTORIA ZLECEŃ: ";
        for(int i = 0; i < liczbaZlecen2; i++){
            wynik += "\n" + (i + 1) + ".  " + zlecenia2[i];
        }
        return wynik;
        
    }
    
     public void Anuluj() {
        
        Zlecenie robocza = zlecenia[liczbaZlecen - 1];
        Zlecenie robocza2 = zlecenia[liczbaZlecen - 1];
        robocza2.Anulowanie(robocza);
        zlecenia2[liczbaZlecen2] = robocza2;
        zlecenia[liczbaZlecen - 1] = null;
        liczbaZlecen--;
        liczbaZlecen2++;
        
    }
    
    public void Wykonaj(int nr) throws IOException{
        if(liczbaZlecen == nr){
        Zlecenie robocza = zlecenia[liczbaZlecen - 1];
        Zlecenie robocza2 = zlecenia[liczbaZlecen - 1];
        robocza2.Wykonanie(robocza);
        zlecenia2[liczbaZlecen2] = robocza2;
        zlecenia[liczbaZlecen - 1] = null;
        liczbaZlecen--;
        liczbaZlecen2++;
            
        }
        else{
        Zlecenie robocza = zlecenia[nr];
        Zlecenie robocza2 = zlecenia[nr];
        robocza2.Wykonanie(robocza);
        zlecenia2[liczbaZlecen2] = robocza2;
        for(int i = nr; i < liczbaZlecen - 1; i++){
            
            zlecenia[i] = zlecenia[i + 1];
        }
        zlecenia[liczbaZlecen - 1] = null;
        liczbaZlecen--;
        liczbaZlecen2++;
    }
    }
    public void Sortowanie(String napis){
        for(int i = 0; i < liczbaZlecen3; i++){
            zlecenia3[i] = null;
            
        }
        
        liczbaZlecen3 = 0;
        
        String sprawdzenie;
        for(int i = 0; i < liczbaZlecen; i++)
        {
            
            sprawdzenie = zlecenia[i].getRegion();
            if(sprawdzenie.equals(napis)){
                zlecenia3[liczbaZlecen3]= zlecenia[i];
                liczbaZlecen3++;
            }
        }
        
    }
    public void Sortowanie2(String napis){
        for(int i = 0; i < liczbaZlecen3; i++){
            zlecenia3[i] = null;
            
        }
        
        liczbaZlecen3 = 0;
        
        String sprawdzenie;
        for(int i = 0; i < liczbaZlecen2; i++)
        {
            
            sprawdzenie = zlecenia2[i].getRegion();
            if(sprawdzenie.equals(napis)){
                zlecenia3[liczbaZlecen3]= zlecenia2[i];
                liczbaZlecen3++;
            }
        }
        
    }  
     public String Posortowane() {
        String wynik = "Posortowane: ";
        for(int i = 0; i < liczbaZlecen3; i++){
            wynik += "\n" + (i + 1) + ".  " + zlecenia3[i];
        }
        return wynik;
        
    }
    
}