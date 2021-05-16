package Wzorce;

public class Rzezba implements Przedmiot{
    
    private int rok_wykonania;
    private double rozmiar;
    private double warto��;
    public double okre�lWarto��(){
        return (2020 - rok_wykonania)* rozmiar* 2;
    }

    @Override
    public String toString() {
        return "Rzezba{" + "rok_wykonania=" + rok_wykonania + ", rozmiar=" + rozmiar + ", wartosc=" + warto�� + '}';
    }
    
    
    public Rzezba(int rok_wykonania, double rozmiar) {
        this.rok_wykonania = rok_wykonania;
        this.rozmiar = rozmiar;
        setWarto��();
    }

    public int getRok_wykonania() {
        return rok_wykonania;
    }


    public double getRozmiar() {
        return rozmiar;
    }

    public double getWarto��() {
        return warto��;
    }

    private void setWarto��() {
        warto��=okre�lWarto��();
    }
}