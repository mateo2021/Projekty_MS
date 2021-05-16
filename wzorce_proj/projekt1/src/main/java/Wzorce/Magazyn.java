package Wzorce;
import java.util.ArrayList;
import java.util.List;
public class Magazyn{   
    public List<Przedmiot> Lista; 
    public void dodajDoSpisu(Przedmiot p){
        Lista.add(p);
    }

    public Magazyn() {
        Lista = new ArrayList();
    }
    
   
    public double pobierzWartoœæPoOpodatkowaniu(Podatek p){
        int n=Lista.size();
        double wartosc=0;
        double k;
        for(int i=0;i<n;i++){
            k=Lista.get(i).okreœlWartoœæ();
            wartosc=wartosc+k;
        }
        wartosc=p.podaj(wartosc);
        return wartosc;
    }
    public void wyswietl(){
        int n=Lista.size();
        int k=1;
        String s;
        for(int i=0;i<n;i++){
            s=Lista.get(i).toString();
            System.out.println("Przedmiot:"+k+" "+s);
            k++;
        }
    }
};
 

