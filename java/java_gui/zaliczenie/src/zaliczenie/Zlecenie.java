
package zaliczenie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Zlecenie {
    private int Dzien;
    private int Miesiac;
    private int Rok;    
    private String Region;
    private String Adres;
    private String Status;

    public Zlecenie(int Dzien, int Miesiac, int Rok, String Region, String Adres, String Status) throws FileNotFoundException, IOException {
        this.Dzien = Dzien;
        this.Miesiac = Miesiac;
        this.Rok = Rok;
        this.Region = Region;
        this.Adres = Adres;
        this.Status = Status;
    }

    public int getDzien() {
        return Dzien;
    }

    public void setDzien(int Dzien) {
        this.Dzien = Dzien;
    }

    public int getMiesiac() {
        return Miesiac;
    }

    public void setMiesiac(int Miesiac) {
        this.Miesiac = Miesiac;
    }

    public int getRok() {
        return Rok;
    }

    public void setRok(int Rok) {
        this.Rok = Rok;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Zlecenie[" +  Dzien + "/" + Miesiac + "/" + Rok + ", Region=" + Region + ", Adres=" + Adres + ", Status=" + Status + ']';
    }
    public void Anulowanie(Zlecenie zlecenie) {
        this.Status = "anulowane";
    }
    
       
            
    public void Wykonanie(Zlecenie zlecenie) throws IOException {
        this.Status = "wykonane";      
        
    


        
        PrintWriter plik2 = null;
        try {
         
            plik2 = new PrintWriter(new FileWriter("C:\\Users\\Mateusz Stadnicki\\Desktop\\java\\java_zaliczenie\\zaliczenie\\zadania_wykonane.txt", true));
                      
            plik2.println(zlecenie);
        } finally {
            if (plik2 != null) {
                plik2.close();
            }
        }
    }

    
    
    
    
}
