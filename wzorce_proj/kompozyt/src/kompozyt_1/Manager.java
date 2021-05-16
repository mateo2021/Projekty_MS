/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozyt_1;

/**
 *
 * @author Mateusz Stadnicki
 */

    class Manager implements PracownicyInterface 
{ 
    private String imie; 
    private String nazwisko; 
    private String position; 
   
    public Manager(String imie, String nazwisko, String position) 
    { 
        this.imie = imie; 
        this.nazwisko = nazwisko; 
        this.position = position; 
    } 
       
    @Override
    public void showEmployeeDetails()  
    { 
        System.out.println(imie+" " +nazwisko+ " " + position ); 
    } 
} 

