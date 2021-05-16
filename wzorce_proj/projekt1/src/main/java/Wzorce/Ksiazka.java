package Wzorce;

public class Ksiazka implements Przedmiot{
    private int rok_wydania;
    private int numer_wydania;
    private double warto��;

    public Ksiazka(int rok_wydania, int numer_wydania) {
        this.rok_wydania = rok_wydania;
        this.numer_wydania = numer_wydania;
        setWarto��();
    }

    @Override
    public String toString() {
        return "Ksiazka{" + "rok_wydania=" + rok_wydania + ", numer_wydania=" + numer_wydania + ", wartosc=" + warto�� + '}';
    }
    
    
    public double okre�lWarto��(){
        return (2050-rok_wydania)/numer_wydania;
    }

    public int getRok_wydania() {
        return rok_wydania;
    }


    public int getNumer_wydania() {
        return numer_wydania;
    }

    public double getWarto��() {
        return warto��;
    }

    private void setWarto��() {
        warto��=okre�lWarto��();
    }
}
