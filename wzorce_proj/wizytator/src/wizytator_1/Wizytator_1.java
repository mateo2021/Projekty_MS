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
public class Wizytator_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Animal animal = new Animal("dog", 30);
        Person person = new Person("Dawid", "Nowak", true);
        Shipment shipment = new Shipment("PL", "4325452", false);
        
        PriceTransportVisitor ptv = new PriceTransportVisitor();
        NameTransportVisitor ntv = new NameTransportVisitor();
        
        person.accept(ptv);
        animal.accept(ntv);
    }
    
}
