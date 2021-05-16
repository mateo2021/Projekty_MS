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
public class CombSort {
    
    long liczba_krokow2 = 0;
    
    
    int getNextGap(int gap) 
    { 
        
        gap = (gap*10)/13; 
        if (gap < 1) 
            return 1; 
        return gap; 
    } 
    
    
   
    void sort(int arr[]) 
    { 
        int n = arr.length; 
  
       
        int gap = n; 
  
       
        boolean swapped = true; 
  
        
        while (gap != 1 || swapped == true) 
        { 
            
            gap = getNextGap(gap); 
  
          
            swapped = false; 
  
           
            for (int i=0; i<n-gap; i++) 
            { 
                if (arr[i] > arr[i+gap]) 
                { 
                   
                    int temp = arr[i]; 
                    arr[i] = arr[i+gap]; 
                    arr[i+gap] = temp; 
  
                    
                    swapped = true; 
                    
                    liczba_krokow2++;
                } 
            } 
        } 
    } 

    public long getLiczba_krokow2() {
        return liczba_krokow2;
    }

    
    
}
