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
public class Person implements  TransportI{
    private String firstName;
    private String lastName;
    private boolean isRegularCustomer;

    public Person(String firstName, String lastName, boolean isRegularCustomer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isRegularCustomer = isRegularCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isIsRegularCustomer() {
        return isRegularCustomer;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    
}
