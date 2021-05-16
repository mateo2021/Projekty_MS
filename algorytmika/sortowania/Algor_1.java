/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algor_1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;



public class Algor_1 {

   
    public static void main(String[] args) throws FileNotFoundException {
        
         //zapis losowych plików do pliku z wybranego zakresu
        
        Random rand = new Random();
        
        try (PrintWriter zapis = new PrintWriter("zapis_liczb.txt")) {
            for(int i=0;i<101001;i++){            //deklaracja !!!!
                zapis.println(rand.nextInt(100002)); // zakres liczb!!!!
                
            }   }  
        
         // deklaracja tablicy i wczytanie z pliku
        
         int[]tab_liczb = new int[101001];
         int[]tab_liczb2 = new int[101001];
         int[]tab_liczb3 = new int[101001];
         int[]tab_liczb4 = new int[101001]; // tablica deklaracja!!!
    
         File file = new File("zapis_liczb.txt");
         Scanner wczytaj = new Scanner(file);
         Scanner wczytaj2 = new Scanner(file);
         Scanner wczytaj3 = new Scanner(file);
         Scanner wczytaj4 = new Scanner(file);
         
         
         for(int i=0;i<101001;i++){    // deklaracja !!!      
           tab_liczb[i]=wczytaj.nextInt();
            tab_liczb2[i]=wczytaj2.nextInt();
             tab_liczb3[i]=wczytaj3.nextInt();
              tab_liczb4[i]=wczytaj4.nextInt();
         }  
         
             

       // MergeSort / MegeSort 
        
        MergeSort ms = new MergeSort();
        long millisActualTime = System.currentTimeMillis();
        ms.sort(tab_liczb);
        long executionTime = System.currentTimeMillis() - millisActualTime;
        
        
        System.out.println("Wynik MergeSort w milisekundach wynosi: " + executionTime );
        System.out.println("Liczba krokow wynosi:  " + ms.getLiczba_krokow3());
                
        
        System.out.println("__________");
        
        //CombSort / Grzebieniowe
//        
        CombSort cs = new CombSort();
        long millisActualTime2 = System.currentTimeMillis();
        cs.sort(tab_liczb2);
        long executionTime2 = System.currentTimeMillis() - millisActualTime2;
        
        System.out.println("Wynik CombSort(Grzebieniowe) w milisekundach wynosi: " + executionTime2 );
         System.out.println("Liczba krokow wynosi:  " + cs.getLiczba_krokow2()); 
//
//        
//        // Radix / Pozycyjne 
         System.out.println("__________"); 
         
        Radix r = new Radix(); 
        long millisActualTime3 = System.currentTimeMillis();       
        r.radixsort(tab_liczb3, tab_liczb3.length);
        long executionTime3 = System.currentTimeMillis() - millisActualTime3;
        
        
         
       System.out.println("Wynik Radix(Pozycyjne) w milisekundach wynosi: " + executionTime3 );
       System.out.println("Liczba krokow wynosi:  " + r.getLiczba_krokow4()); 
        
      
        
        // Insertion / Sortowanie przez wstawianie
        System.out.println("__________");
        
        Insertion in = new Insertion();
        long millisActualTime4 = System.currentTimeMillis(); 
        in.sort(tab_liczb4);
        long executionTime4 = System.currentTimeMillis() - millisActualTime4;
        
        
        System.out.println("Wynik Insertion (Sortowanie przez wstawianie) w milisekundach wynosi: " + executionTime4 );
        System.out.println("Liczba krokow wynosi:  " + in.getLiczba_krokow()); 
        
        
        // sprawdzenie i wyswietlenie uporzadkowanej tablicy
                
//           for(int i=0;i<tab_liczb.length;i++){
//          System.out.println(tab_liczb4[i]);}
//    
    
    
    
    }
    
    
}
