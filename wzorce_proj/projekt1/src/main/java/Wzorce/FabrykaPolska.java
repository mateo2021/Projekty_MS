package Wzorce;
public class FabrykaPolska implements Fabryka{
    public Podatek liniowy(){
        Podatek p=new Podatek();
        PodatekLiniowy L=new PodatekLiniowy();
        p.setPodatekStrategia(L);
        return p;
    }
    public Podatek progresywny(){
        Podatek p=new Podatek();
        PodatekProgresywny P=new PodatekProgresywny();
        p.setPodatekStrategia(P);
        return p;
    }
}
