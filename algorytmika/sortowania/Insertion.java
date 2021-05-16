/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algor_1;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Insertion {
   public long  liczba_krokow = 0;
    
    void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            
  
           
            while (j >= 0 && arr[j] > key) { 
                liczba_krokow++;
                arr[j + 1] = arr[j]; 
                
                j = j - 1; 
                
                
            } 
           
            arr[j + 1] = key; 
        } 
        
    } 

    public long getLiczba_krokow() {
        return  liczba_krokow;
    }

    
    
    
    
}
