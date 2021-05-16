package Wzorce;
public class Obraz implements Przedmiot{
    private int rok_namalowania;
    private double warto��;

    @Override
    public String toString() {
        return "Obraz{" + "rok_namalowania=" + rok_namalowania + ", wartosc" + warto�� + '}';
    }

    
    public Obraz(int rok_namalowania) {
        this.rok_namalowania = rok_namalowania;
        setWarto��();
    }
    
    
    public double okre�lWarto��(){
        return ( 2100 - rok_namalowania)*10;
    }

    public int getRok_namalowania() {
        return rok_namalowania;
    }

    public double getWarto��() {
        return warto��;
    }

    private void setWarto��() {
        warto��=okre�lWarto��();
    }
}

