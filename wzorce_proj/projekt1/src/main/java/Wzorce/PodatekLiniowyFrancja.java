package Wzorce;
public class PodatekLiniowyFrancja implements PodatekStrategia{
    public double Evaluate(double kwota)
    {
        return kwota *0.30;
    }
} 