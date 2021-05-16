/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozyt_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz Stadnicki
 */
public class CompanyDirectory implements PracownicyInterface{
    
    private List<PracownicyInterface> employeList = new ArrayList<PracownicyInterface>();

    @Override
    public void showEmployeeDetails() {
      for(PracownicyInterface emp :employeList){
          
          
          emp.showEmployeeDetails();
      }
    }
    
    public void addEmployee(PracownicyInterface emp){
        employeList.add(emp);
    }
    public void removeEmployee(PracownicyInterface emp){
        employeList.remove(emp);
    }
}
