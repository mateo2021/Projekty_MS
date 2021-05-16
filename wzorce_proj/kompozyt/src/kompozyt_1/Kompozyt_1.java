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
public class Kompozyt_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Developer d1 = new Developer("MATEUSZ", "STADNICKI", "PROGRAMIST");
       
       CompanyDirectory devAdd = new  CompanyDirectory();
       
       devAdd.addEmployee(d1);
       
       
       Manager m1 = new Manager("Tadeusz","Wjheusz", "IOS Manager");
       
       CompanyDirectory manAdd = new CompanyDirectory();
       
       manAdd.addEmployee(m1);
       
       CompanyDirectory directory = new CompanyDirectory();
       directory.addEmployee(devAdd);
       directory.addEmployee(manAdd);
       
       directory.showEmployeeDetails();
    }
    
}
