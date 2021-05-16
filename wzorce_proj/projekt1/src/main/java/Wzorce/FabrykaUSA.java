package Wzorce;
public class FabrykaUSA implements Fabryka{
    public Podatek liniowy(){
        Podatek p=new Podatek();
        PodatekUSA U=new PodatekUSA();
        p.setPodatekStrategia(U);
        return p;
    }
    public Podatek progresywny(){
        Podatek p=new Podatek();
        PodatekUSA U=new PodatekUSA();
        p.setPodatekStrategia(U);
        return p;
    }
}
