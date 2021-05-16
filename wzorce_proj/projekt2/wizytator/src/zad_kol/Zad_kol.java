/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad_kol;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Zad_kol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       A a = new A("A");
       B b = new B("B");
       pliki_txt txt1 = new pliki_txt("1.txt", 4);
       pliki_txt txt2 = new pliki_txt("2.txt", 8);
       pliki_xml xml1 = new pliki_xml("a.xml", 4);
       pliki_xml xml2 = new pliki_xml("b.xml", 32);
       
      a.add(txt1);
      a.add(txt2);
      b.add(xml1);
      b.add(xml2);
      
       
      Korzen k = new Korzen("Korzen");
      
      k.add(a);
      k.add(b);
      
      k.show();
      
      
      VisitatorLiczbaPlikow vlp = new VisitatorLiczbaPlikow();
      
      vlp.visit(k);
      vlp.visit(a);
      vlp.visit(b);
      
    }
    
}
