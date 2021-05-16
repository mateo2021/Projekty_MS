/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algor_1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Radix {
    
    public long liczba_krokow4 =0;
    
   public void radixSort(int[] array) {
     int counter = 0;
     LinkedList<LinkedList<Integer>> allBuckets = new LinkedList<>();

     for (int i = 0; i < 10; i++) {
          allBuckets.addLast( new LinkedList<>() );
     }

     for (int i = 0; i < array.length; i++) {
          int j = array[ i ] % 10;
          allBuckets.get( j ).addLast( array[ i ] );
          
     }

     for (int i = 0; i < 10; i++){
          while ( !allBuckets.get( i ).isEmpty() ) {
               array[ counter ] = allBuckets.get( i ).pollFirst();
             
          }
     }

     for (int i = 0; i < array.length; i++) {
          int j = ( (int ) ( array[ i ] / 10 ) ) % 10;
          allBuckets.get( j ).addLast( array[ i ] );
          
     }

     counter = 0;

     for (int i = 0; i < 10; i++) {
          for (int j = 0; j < allBuckets.get( i ).size(); j++) {
               array[ counter ] = allBuckets.get( i ).get( j );
               
          }
     }
}


public  int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
public void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        int liczba=0;
        
        Arrays.fill(count,0); 
  
        // Przechowuje liczbe wystapien 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
        
  
        // zamienia pozycje liczby aby ta byla rzeczywista na wyjsciu 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
        
        
        
  
        // Tablica wyjsciowa 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // kopiuje tablice do tablicy aby w arr znalazły sie posorotwane liczby 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
        
    } 

 public void radixsort(int arr[], int n) 
    { 
        // Znajduej max liczbe w tablicy 
        int m = getMax(arr, n); 
  
        for (int exp = 1; m/exp > 0; exp *= 10) {
            countSort(arr, n, exp); 
            
            liczba_krokow4++;
     
        }} 

    public long getLiczba_krokow4() {
        return liczba_krokow4;
    }
    
   
}
    
    

