package Wzorce;
public class FabrykaFrancja implements Fabryka{
    public Podatek liniowy(){
        Podatek p=new Podatek();
        PodatekLiniowyFrancja L=new PodatekLiniowyFrancja();
        p.setPodatekStrategia(L);
        return p;
    }
    public Podatek progresywny(){
        Podatek p=new Podatek();
        PodatekProgresywnyFrancja P=new PodatekProgresywnyFrancja();
        p.setPodatekStrategia(P);
        return p;
    }
}