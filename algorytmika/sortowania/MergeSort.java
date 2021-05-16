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
public class MergeSort {
    
    public long liczba_krokow3 = 0;
      
     private int[] numbers;
private int[] helper;

private int number;
private int comparisons, exchanges;

public void sort(int[] values) {
    this.numbers = values;
    number = values.length;
    this.helper = new int[number];
    mergesort(0, number - 1);
    liczba_krokow3=comparisons+exchanges;
    System.out.println();
}

private void mergesort(int low, int high) {
    // Check if low is smaller then high, if not then the array is sorted
    if (low < high) 
    {
        // Get the index of the element which is in the middle
        int middle = (low + high) / 2;
        // Sort the left side of the array
        mergesort(low, middle);
        // Sort the right side of the array
        mergesort(middle + 1, high);
        // Combine them both
        merge(low, middle, high);
    }
}

private void merge(int low, int middle, int high) {

    // Copy both parts into the helper array
    for (int i = low; i <= high; i++) {
        helper[i] = numbers[i];
        exchanges++;
    }
    int i = low;
    int j = middle + 1;
    int k = low;
    // Copy the smallest values from either the left or the right side back
    // to the original array
    while (i <= middle && j <= high) {
        if (helper[i] <= helper[j]) {
            numbers[k] = helper[i];
            i++;
            exchanges++;
        } else {
            numbers[k] = helper[j];
            j++;
            exchanges++;
        }
        k++;
        comparisons++;

    }
    // Copy the rest of the left side of the array into the target array
    while (i <= middle) {
        numbers[k] = helper[i];
        exchanges++;
        k++;
        i++;
    }
}  

    public long getLiczba_krokow3() {
        return liczba_krokow3;
    }



}

 
