package Wzorce;
public class PodatekProgresywnyFrancja implements PodatekStrategia{
    public double Evaluate(double kwota)
    {
        if(kwota<=40000){
            return kwota *0.30;
        }
        else{
            return kwota*0.50;
        }
    }
} 
