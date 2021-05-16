/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad_kol;

/**
 *
 * @author Mateusz Stadnicki
 */
public interface Visitator {
    void visit(Korzen korzen);
    void visit(B b);
    void visit(A a);
}
