/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizytator_1;

/**
 *
 * @author Mateusz Stadnicki
 */
public class PriceTransportVisitor implements Visitor{

    @Override
    public void visit(Animal animal) {
        int price =0;
        System.out.println("Cena za km:" + animal.getWeight()*0.2);
      
    }

    @Override
    public void visit(Person person) {
       int price =6;
       if(person.isIsRegularCustomer()){
           price = price/2;
       }
       
        System.out.println("Cena za km dla osoby :" + price);
    }

    @Override
    public void visit(Shipment shipment) {
       int price =2;
       if(shipment.isIsLarge()){
           price*=3;
       }
        System.out.println("Przesylka / koszt "+ price);
    }
    
    
    
}
