package Wzorce;
public class FabrykaNiemcy implements Fabryka{
    public Podatek liniowy(){
        Podatek p=new Podatek();
        PodatekLiniowyNiemcy L=new PodatekLiniowyNiemcy();
        p.setPodatekStrategia(L);
        return p;
    }
    public Podatek progresywny(){
        Podatek p=new Podatek();
        PodatekProgresywnyNiemcy P=new PodatekProgresywnyNiemcy();
        p.setPodatekStrategia(P);
        return p;
    }
}
