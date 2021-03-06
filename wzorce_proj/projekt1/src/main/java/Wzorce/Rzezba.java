package Wzorce;

public class Rzezba implements Przedmiot{
    
    private int rok_wykonania;
    private double rozmiar;
    private double wartość;
    public double określWartość(){
        return (2020 - rok_wykonania)* rozmiar* 2;
    }

    @Override
    public String toString() {
        return "Rzezba{" + "rok_wykonania=" + rok_wykonania + ", rozmiar=" + rozmiar + ", wartosc=" + wartość + '}';
    }
    
    
    public Rzezba(int rok_wykonania, double rozmiar) {
        this.rok_wykonania = rok_wykonania;
        this.rozmiar = rozmiar;
        setWartość();
    }

    public int getRok_wykonania() {
        return rok_wykonania;
    }


    public double getRozmiar() {
        return rozmiar;
    }

    public double getWartość() {
        return wartość;
    }

    private void setWartość() {
        wartość=określWartość();
    }
}