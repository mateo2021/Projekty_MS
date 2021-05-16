package Wzorce;
public class PodatekProgresywnyNiemcy implements PodatekStrategia{
    public double Evaluate(double kwota)
    {
        if(kwota<=50000){
            return kwota *0.20;
        }
        else{
            return kwota*0.40;
        }
    }
} 