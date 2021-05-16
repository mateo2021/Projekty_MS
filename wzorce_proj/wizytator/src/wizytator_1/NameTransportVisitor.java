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
public class NameTransportVisitor implements Visitor{

    @Override
    public void visit(Animal animal) {
        System.out.println("Typ zwierzecia: " + animal.getKind());
    }

    @Override
    public void visit(Person person) {
        System.out.println("imie: " + person.getFirstName()+" nazwisko: " + person.getLastName());
    }

    @Override
    public void visit(Shipment shipment) {
        System.out.println("prefix: " + shipment.getPrefix() + "serial: "+ shipment.getSerialNumber());
    }
    
    
    
}
