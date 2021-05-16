package Wzorce;
public class Main {
    public static void main(String[] args) {
        double prog,lin;
        Przedmiot ksiazka=new Ksiazka(2000,2);
        Przedmiot obraz=new Obraz(1800);
        Przedmiot rzezba=new Rzezba(1500,3);
        Magazyn m=new Magazyn();
        
        m.dodajDoSpisu(obraz);
        m.dodajDoSpisu(ksiazka);
        m.dodajDoSpisu(rzezba);
        
        // testy do czesci 1
//        m.wyswietl();
        
//        PodatekLiniowy liniowy=new PodatekLiniowy();
//        PodatekProgresywny progresywny=new PodatekProgresywny();
//        Podatek p=new Podatek();
//        p.setPodatekStrategia(liniowy);
//      
//        lin=m.pobierzWartoœæPoOpodatkowaniu(p);
//        p.setPodatekStrategia(progresywny);
//        prog=m.pobierzWartoœæPoOpodatkowaniu(p);
//        System.out.println("Wartosc podatku dla magazynu dla podatku liniowego:"+lin);
//        System.out.println("Wartosc podatku dla magazynu liczona dla podatku progresywnego :"+prog);
        Podatek p=new Podatek();
        Fabryka f=new FabrykaUSA();
        Fabryka f1=new FabrykaPolska();
        Fabryka f2=new FabrykaFrancja();
        Fabryka f3=new FabrykaNiemcy();
        
        
        p=f.liniowy();
        lin=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z podatiem liniowym w USA:"+lin);
        p=f1.liniowy();
        lin=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z podatiem liniowym w Polsce:"+lin);
        p=f2.liniowy();
        lin=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z podatiem liniowym we Francji:"+lin);
        p=f3.liniowy();
        lin=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z podatiem liniowym w Niemczech:"+lin);
          
          
        p=f.progresywny();
        prog=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z podatiem progresywnym w USA:"+prog);
        p=f1.progresywny();
        prog=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z podatiem progresywnym w Polsce:"+prog);
        p=f2.progresywny();
        prog=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z  podatiem progresywnym we Francji:"+prog);
        p=f3.progresywny();
        prog=m.pobierzWartoœæPoOpodatkowaniu(p);
        System.out.println("Wartosc podatku dla magazynu z podatiem progresywnym w Niemczech:"+prog);
        
        
          




//testowanie fabryk
////          Fabryka f=new FabrykaUSA();
////          Fabryka f1=new FabrykaPolska();
////          Fabryka f2=new FabrykaFrancja();
////          Fabryka f3=new FabrykaNiemcy();
////          Podatek p=new Podatek();
////          p=f.liniowy();
////          System.out.println(p.podaj(10000));
////          p=f1.liniowy();
////          System.out.println(p.podaj(10000));
////          p=f2.liniowy();
////          System.out.println(p.podaj(10000));
////          p=f3.liniowy();
////          System.out.println(p.podaj(10000));
////          
////          
////          p=f.progresywny();
////          System.out.println(p.podaj(100000));
////          p=f1.progresywny();
////          System.out.println(p.podaj(100000));
////          p=f2.progresywny();
////          System.out.println(p.podaj(100000));
////          p=f3.progresywny();
////          System.out.println(p.podaj(100000));
          
          
          
          
      
        
    }
    
}
