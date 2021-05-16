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
public class Animal implements TransportI {
    private String kind;
    private int weight;

    public Animal(String kind, int weight) {
        this.kind = kind;
        this.weight = weight;
    }
    
    

    public String getKind() {
        return kind;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
    
    
    
}
